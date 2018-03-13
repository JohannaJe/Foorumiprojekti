package foorumi.foorumi.Kontrolleri;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Kontrolleri {

    @RequestMapping("/")
    public String Etusivu(Model model) {
        model.addAttribute("otsikko", "Etusivu");
        return "Etusivu";
    }

//    @GetMapping("/Autohullut")
//    public String Autohullut(Model model) {
//        model.addAttribute("otsikko", "Autohullut");
//        return "Autohullut";
//    }




}
