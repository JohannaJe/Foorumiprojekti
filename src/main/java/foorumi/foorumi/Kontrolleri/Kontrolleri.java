package foorumi.foorumi.Kontrolleri;

import foorumi.foorumi.Hakusana;
import foorumi.foorumi.Kayttaja.Kayttajarepo;
import foorumi.foorumi.Viesti.Viesti;
import foorumi.foorumi.Viesti.Viestirepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class Kontrolleri {

    private Viestirepo vr;
    private Kayttajarepo kr;
    private JdbcTemplate jdbc;

    public Kontrolleri(@Autowired Viestirepo vr, @Autowired JdbcTemplate jdbc) {
        this.vr = vr;
        this.jdbc = jdbc;
    }

    // Palauttaa kaikki viestit tietokannasta perustuen foorumin metodissa muodostettuun sql-lausekkeeseen!
    private List<Viesti> getViestit(String sql) {
        return jdbc.query(sql,
                (rs, index)->{
                    Viesti kirjoitus = new Viesti();
                    kirjoitus.setTeksti(rs.getString("teksti"));
                    kirjoitus.setKayttaja(rs.getString("kayttaja"));
                    kirjoitus.setId(rs.getInt("id"));
                    kirjoitus.setAlue(rs.getString("alue"));
                    return kirjoitus;
                });
    }

    // Avaa lisaaviesti sivun, jolla luodaan uusi viesti. Jokaisen foorumin alaosassa kutsu tälle.
    @GetMapping("/viestilomake")
    public String viestit(Model model) {
        model.addAttribute("viestiOlio", new Viesti());
        return "lisaaviesti";
    }

    // Viestin lisäys lomakkeelta palataan tähän, joka tallentaa viestin DB:hen ja ohjaa takaisin oikealle foorumille!
    @PostMapping("/ohjaus")
    public String ohjattuUrli(@ModelAttribute Viesti viesti, Model model){
        Viesti uusi = new Viesti();
        uusi.setTeksti(viesti.getTeksti());
        uusi.setKayttaja(viesti.getKayttaja());
        uusi.setAlue(viesti.getAlue());
        vr.save(uusi);
        String url = "redirect:/" + viesti.getAlue().toLowerCase();
        return url;
    }

    // Avaa etusivun ja aktivoi haun
    @RequestMapping("/etusivu")
    public String etusivu(Model model) {
        model.addAttribute("otsikko", "Etusivu");
        model.addAttribute( "haku", new Hakusana());
        return "Etusivu";
    }

    // Aktivoi autohullut-foorumin ja printtaa kaikki sen viestit näkyville
    @RequestMapping("/autohullut")
    public String lomakeKasittelija(@ModelAttribute Viesti viesti, Model model) {
        String sql = "SELECT teksti, kayttaja, id, alue FROM viesti WHERE alue = 'Autohullut'";
        List<Viesti> viestit = getViestit(sql);
        model.addAttribute("viestit", viestit);
        return "autohullut";
    }

    // Aktivoi kalajutut-foorumin ja printtaa kaikki sen viestit näkyville
    @RequestMapping("/kalajutut")
    public String lisaaKeskusteluKalajutuista(Model model) {
        String sql = "SELECT teksti, kayttaja, id, alue FROM viesti WHERE alue = 'Kalajutut'";
        List<Viesti> viestit = getViestit(sql);
        model.addAttribute("viestit", viestit);
        return "kalajutut";
    }

    // Aktivoi leffalopinat-foorumin ja printtaa kaikki sen viestit näkyville
    @RequestMapping("/leffalopinat")
    public String leffalopinat(Model model) {
        String sql = "SELECT teksti, kayttaja, id, alue FROM viesti WHERE alue = 'Leffalopinat'";
        List<Viesti> viestit = getViestit(sql);
        model.addAttribute("viestit", viestit);
        return "leffalopinat";
    }

    // Aktivoi golfjuorut-foorumin ja printtaa kaikki sen viestit näkyville
    @RequestMapping("/golfjuorut")
    public String golfjuorut(Model model) {
        String sql = "SELECT teksti, kayttaja, id, alue FROM viesti WHERE alue = 'Golfjuorut'";
        List<Viesti> viestit = getViestit(sql);
        model.addAttribute("viestit", viestit);
        return "golfjuorut";
    }

    /* Poistaa halutun viestin sivuilta sekä tietokannasta ID:n avulla, joka on piilotettuna kenttänä listoilla.
       Ohjaa takaisin sivulle, jolta viesti poistettiin.
     */
    @GetMapping("/poista")
    public String poistaViesti(@RequestParam(name = "id") int id, Model model) {
        Optional<Viesti> optviesti = vr.findById(id);
        if (!optviesti.isPresent()) {
            throw new RuntimeException("Poistetaan olematonta viestiä!");
        }
        String url = "redirect:/" + optviesti.get().getAlue().toLowerCase();
        vr.deleteById(id);
        return url;
    }

    // Lähettää muokattavan viestin muokkaus-muokkaus sivulle ID:n perusteella
    @GetMapping("/muokkaa")
    public String muokkaaViesti(@RequestParam(name = "id") int id, Model model) {
        Optional<Viesti> optviesti = vr.findById(id);
        if (!optviesti.isPresent()) {
            throw new RuntimeException("Muokataan olematonta viestiä");
        }
        model.addAttribute("viesti", optviesti.get());
        return "muokkaus";
    }

    /* Muokkaa halutun viestin kirjoittaijan tai itse tekstin ja päivittää tämän DB:hen sekä sivuille.
       Palaa takaisin muokatun viestin alueelle ja päivitys näkyy heti.
     */
    @PostMapping("/muokattu")
    public String tallennaMuokattu(Viesti viesti, Model model) {
        if (viesti == null || viesti.getTeksti() == null || viesti.getTeksti().trim().isEmpty())
            throw new RuntimeException("Ei pitäis päätyä tänne, tyhjä viesti");
        String sql = "UPDATE viesti SET kayttaja = '" + viesti.getKayttaja() + "', teksti = '" + viesti.getTeksti() + "' WHERE id = " + viesti.getId();
        jdbc.update(sql);
        String url = "redirect:/" + viesti.getAlue().toLowerCase();
        return url;
    }

    /* Metodia kutsutaan etusivulta, kun haetaan viestejä foorumilta.
       Sanaa tai kirjaimia etsitään joko käyttäjästä tai viestistä.
       Metodi palauttaa kaikki sopivat haetut-sivulle, jonka jälkeen käyttäjä voi muokata tai poistaa viestejä.
       Jos hakusana on tyhjä, palataan etusivulle.
     */
    @GetMapping("/hakutulokset")
    public String haetutViestit(Hakusana sana, Model model) {
        String sql = "SELECT teksti, kayttaja, id, alue FROM viesti WHERE (teksti LIKE '%"+sana+"%' OR kayttaja LIKE '%"+sana+"%')";
        if (sana == null || sana.getHakusana() == null || sana.getHakusana().trim().isEmpty())
            return "redirect:etusivu";
        model.addAttribute("viestit", getViestit(sql));
        return "haetut";
    }

    // Yritä kirjautua -> palaat etusivulle. WORK IN PROGRESS!
    @GetMapping("/kirjautunut")
    public String kirjautunutSisaan(Model model){
        return "etusivu";
    }

    // Yritä rekisteröityä -> palaat etusivulle. WORK IN PROGRESS!
    @GetMapping("/rekisteroitynyt")
    public String rekisteroitynytPalveluun(Model model){
        return "etusivu";
    }
}

