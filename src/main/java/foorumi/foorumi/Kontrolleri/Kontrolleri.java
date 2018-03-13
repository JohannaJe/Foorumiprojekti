package foorumi.foorumi.Kontrolleri;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Kontrolleri {

    @RequestMapping("/")
    public String indeksi(Model model) {
        model.addAttribute("otsikko", "Etusivu");
        return "Etusivu";
    }

}
