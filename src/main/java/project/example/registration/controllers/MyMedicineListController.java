package project.example.registration.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import project.example.registration.services.MyMedicineListService;

@Controller
public class MyMedicineListController {
    @Autowired
    private MyMedicineListService myMedicineListservice;
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id){
        myMedicineListservice.deleteById(id);
        return "redirect:/my_medicines";
    }

}