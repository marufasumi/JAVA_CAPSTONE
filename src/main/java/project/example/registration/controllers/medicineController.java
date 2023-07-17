package project.example.registration.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import project.example.registration.entities.Medicine;
import project.example.registration.entities.MyMedicineList;
import project.example.registration.services.MedicineService;
import project.example.registration.services.MyMedicineListService;

import java.util.List;

@Controller
public class medicineController {
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private MyMedicineListService myMedicineListService;
    @GetMapping("/logout")
    public String logout(){

        return "index";

    }

    @GetMapping("/medicine_register")
    public String medicineRegister(){
        return "medicineRegister";
    }
    @GetMapping("/available_medicines")
    public ModelAndView getAllMedicines(ModelAndView modelAndView) {
        List<Medicine> list = medicineService.getAllMedicines();
        modelAndView.addObject("medicine", list);
        modelAndView.setViewName("medicineList");
        return modelAndView;
    }

    @GetMapping ("/my_medicines")
    public String getMyMedicines(Model model){

        List<MyMedicineList> list =myMedicineListService.getAllMyMedicines();
        model.addAttribute("medicine",list);

        return "myMedicines";
    }

    @PostMapping("/save")
    public String  addMedicine(@ModelAttribute Medicine medicine){
        medicineService.save(medicine);
        return "redirect:/available_medicines";
        // we need to call save method to save the book.for this we need to autowired medicineService class

    }

    @RequestMapping("/add-to-my-medicine/{id}")

    public String getMyList(@PathVariable("id") int id){
        Medicine m = medicineService.getMedicineById(id);
        MyMedicineList myMedicineList =new MyMedicineList(m.getId(),m.getClassName(),m.getBrandName(),m.getPrice());
        myMedicineListService.saveMyMedicines(myMedicineList);



        return "redirect:/my_medicines";

    }

    @RequestMapping("/editMedicine/{id}")
    public String  editMedicine(@PathVariable ("id") int id, Model model){
        Medicine m = medicineService.getMedicineById(id);

        model.addAttribute("medicine",m);



        return "medicineEdit";
    }

    @RequestMapping("/deleteMedicine/{id}")
    public String deleteBook(@PathVariable("id") int id){
        medicineService.deleteById(id);

        return "redirect:/available_medicines";
    }


}