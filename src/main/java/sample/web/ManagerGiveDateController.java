package sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by marek on 08.01.17.
 */
@Controller
public class ManagerGiveDateController {

    @GetMapping("/managerGiveDate")
    public String getMenagerGiveDate(){
        return "managerGiveDate";
    }

}
