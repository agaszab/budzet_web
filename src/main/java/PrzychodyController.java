import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;



@Controller
public class PrzychodyController {

    private Przychody przychody;

    public PrzychodyController(Przychody przychody) {
        this.przychody = przychody;
    }

    public PrzychodyController() {
    }

    @RequestMapping("/")
    public static String main() {

        return "index";
    }


    @RequestMapping("/list")
    public String opcje(Model model, @RequestParam Opcje opcja) throws SQLException {

        PrzychodyDao dao = new PrzychodyDao();

        switch (opcja) {
            case DODAJ_PRZYCHOD: {
                przychody = new Przychody();
                przychody.setType("przychody");
                model.addAttribute("newPrzychody", new Przychody());
                return "formularz";
            }
            case DODAJ_WYDATEK: {
                przychody = dao.wczytaj("wydatki");
                dao.save(przychody);
                break;
            }
            case POKAZ_PRZYCHODY: {
                dao.show("przychody");
                break;
            }
            case POKAZ_WYDATKI: {
                dao.show("wydatki");
                break;
            }


            //model.addAttribute("przychody", przychody);

        }
        return "lista";

    }
}