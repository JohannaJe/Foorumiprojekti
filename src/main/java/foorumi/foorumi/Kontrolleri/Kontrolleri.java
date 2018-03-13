package foorumi.foorumi.Kontrolleri;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Kontrolleri {

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




}
