package foorumi.foorumi.Kontrolleri;

import foorumi.foorumi.Aihe.Aiherepo;
import foorumi.foorumi.Viesti.Viesti;
import foorumi.foorumi.Viesti.Viestirepo;
import foorumi.foorumi.Viesti.Viestit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class Kontrolleri {

    private Viestirepo vr;

    private Aiherepo ar;

    public Kontrolleri(@Autowired Viestirepo vr, @Autowired Aiherepo ar) {
        this.vr = vr;
        this.ar = ar;
    }

    Viesti viesti = new Viesti();
    Viestit viestit = new Viestit(new ArrayList<>());

    @RequestMapping("/etusivu")
    public String Etusivu(Model model) {
        model.addAttribute("otsikko", "Etusivu");
        return "Etusivu";
    }

    @RequestMapping("/autohullut")
    public String Autohullut(@ModelAttribute Viesti viesti, Model model) {
        model.addAttribute("viestit", viestit.getViestit());
        return "Autohullut";
    }

    @GetMapping("/viestilomake")
    public String viestit(Model model) {
        model.addAttribute("viestiOlio", new Viesti());
        return "lisaaviesti";
    }

    @PostMapping("/viestisivu")
    public String lomakeKasittelija(@ModelAttribute Viesti viesti,@RequestParam("id") int id) {
        viesti.setAihe(ar.findById(id).get());
        vr.save(viesti);
        return "redirect:/viestisivu"+"?id="+id;
    }

//    @RequestMapping("/kalajutut")
//    public String Kalajutut(Model model) {
//        model.addAttribute("otsikko", "Kalajutut");
//        return "Kalajutut";
//    }
//
//    @RequestMapping("/leffalopinat")
//    public String Leffalopinat(Model model) {
//        model.addAttribute("otsikko", "Leffalopinat");
//        return "Leffalopinat";
//    }
//
//    @RequestMapping("/golfjuorut")
//    public String Golfjuorut(Model model) {
//        model.addAttribute("otsikko", "Golfjuorut");
//        return "Golfjuorut";
//    }



    @GetMapping("/muokkaa")
    public String muokkaaViestia(@RequestParam(name = "id") int id, Model model) {
        Viesti etsitty = viestit.etsi(id);
        if (etsitty == null)
            return "Etusivu";
        model.addAttribute("viesti", etsitty);
        return "muokkaus";
    }

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
