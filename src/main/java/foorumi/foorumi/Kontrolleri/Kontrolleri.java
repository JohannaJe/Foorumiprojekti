package foorumi.foorumi.Kontrolleri;

import foorumi.foorumi.Aihe.Aihe;
import foorumi.foorumi.Aihe.Aiherepo;
import foorumi.foorumi.Hakusana;
import foorumi.foorumi.Viesti.Viesti;
import foorumi.foorumi.Viesti.Viestirepo;
import foorumi.foorumi.Viesti.Viestit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Kontrolleri {

    private Viestirepo vr;

    private Aiherepo ar;
    private JdbcTemplate jdbc;

    public Kontrolleri(@Autowired Viestirepo vr, @Autowired Aiherepo ar, @Autowired JdbcTemplate jdbc) {
        this.vr = vr;
        this.ar = ar;
        this.jdbc = jdbc;
    }

    Viesti viesti = new Viesti();
    Viestit viestit = new Viestit(new ArrayList<>());

    @RequestMapping("/etusivu")
    public String Etusivu(Model model) {
        model.addAttribute("otsikko", "Etusivu");
        model.addAttribute( "haku", new Hakusana());
        return "Etusivu";
    }

    @GetMapping("/autohullut")
    public String listaaKeskusteluAutoista(Model model){
        String sql = "SELECT teksti, kayttaja, id, alue FROM viesti WHERE alue = 'Autohullut'";
        List<Viesti> viestit = jdbc.query(sql,
                (rs, index)->{
                    Viesti c = new Viesti();
                    c.setTeksti(rs.getString("teksti"));
                    c.setKayttaja(rs.getString("kayttaja"));
                    c.setId(rs.getInt("id"));
                    c.setAlue(rs.getString("alue"));
                    return c;
                });
        model.addAttribute("viestit", viestit);
        return "autohullut";
    }

    @GetMapping("/viestilomake")
    public String viestit(Model model) {
        model.addAttribute("viestiOlio", new Viesti());
        return "lisaaviesti";
    }

    @PostMapping("/autohullut")
    public String lomakeKasittelija(@ModelAttribute Viesti viesti, Model model) {
        Viesti uusi = new Viesti();
        uusi.setTeksti(viesti.getTeksti());
        uusi.setKayttaja(viesti.getKayttaja());
        uusi.setAlue(viesti.getAlue());
        vr.save(uusi);
        String sql = "SELECT teksti, kayttaja, id, alue FROM viesti WHERE alue = 'Autohullut'";
        List<Viesti> viestit = jdbc.query(sql,
                (rs, index)->{
                    Viesti c = new Viesti();
                    c.setTeksti(rs.getString("teksti"));
                    c.setKayttaja(rs.getString("kayttaja"));
                    c.setId(rs.getInt("id"));
                    c.setAlue(rs.getString("alue"));
                    return c;
                });
        model.addAttribute("viestit", viestit);
        return "autohullut";
    }

    @RequestMapping("/kalajutut")
    public String Kalajutut(Model model) {
        model.addAttribute("otsikko", "Kalajutut");
        return "Kalajutut";
    }

    @RequestMapping("/leffalopinat")
    public String Leffalopinat(Model model) {
        model.addAttribute("otsikko", "Leffalopinat");
        return "Leffalopinat";
    }

    @RequestMapping("/golfjuorut")
    public String Golfjuorut(Model model) {
        model.addAttribute("otsikko", "Golfjuorut");
        return "Golfjuorut";
    }

    /*@RequestMapping("/Etusivu")
    public String hakunappi (Model model) {
        model.addAttribute( "haku", new Hakusana() );
        return "Etusivu";

    }*/

   /* @PostMapping("/hakutulos")
    public String haku(@ModelAttribute Hakusana hakusana, Model model) {
        model.addAttribute( "hakutulos", vr.findByNameStartingWith( hakusana.getHakusana() ) );
        return "Etusivu";

    }*/

    @PostMapping("/hakutulos")
    public String haku(@ModelAttribute Hakusana hakusana, Model model) {
        model.addAttribute( "hakutulos", vr.haeKirjaimella(hakusana.getHakusana() ) );
        return "Etusivu";
    }


   /* @GetMapping("/muokkaa")
    public String muokkaaViestia(@RequestParam(name = "id") int id, Model model) {
        Viesti etsitty = viestit.etsi(id);
        if (etsitty == null)
            return "Etusivu";
        model.addAttribute("viesti", etsitty);
        return "muokkaus";
    }*/

    /*@PostMapping("/muokattu")
    public String tallennaMuokattu(Viesti viesti, Model model) {
        viestit.muokkaa(viesti);
        return "Etusivu";
    }*/

    /*@GetMapping("/poista")
    public String poistaViesti(@RequestParam(name = "id") int id) {
        viestit.poista(id);
        return "Etusivu";
    }*/

    @DeleteMapping("/poista/{id}")
    public String poistaViesti(@PathVariable(name = "id") int id) {
        vr.deleteById(id);
        return "Etusivu";
    }

    @PutMapping("/muokkaa/{id}")
    public String muokkaaViestia(@PathVariable(name = "id") int id, @RequestBody Viesti viesti) {
        viesti.setId(id);
        vr.save(viesti);
        return "Etusivu";
    }

}
