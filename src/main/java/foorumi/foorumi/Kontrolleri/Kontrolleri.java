package foorumi.foorumi.Kontrolleri;

import foorumi.foorumi.Viesti.Viesti;
import foorumi.foorumi.Viestit.Viestit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class Kontrolleri {

    Viestit viestit = new Viestit(new ArrayList<>());

    @RequestMapping("/etusivu")
    public String Etusivu(Model model) {
        model.addAttribute("otsikko", "Etusivu");
        return "Etusivu";
    }

    @RequestMapping("/autohullut")
    public String Autohullut(Model model) {
        model.addAttribute("otsikko", "Autohullut");
        return "Autohullut";
    }

    @GetMapping("/autohullut")
    public String viestit(Model model) {
        model.addAttribute("viestiOlio", new Viesti());
        return "lisaaviesti";
    }

    @PostMapping("/autohullut")
    public String lomakeKasittelija(@ModelAttribute Viesti viesti, Model model) {
        viestit.lisaaListalle(viesti);
        model.addAttribute("viestit", viestit.getViestit());
        return "Autohullut";
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




}
