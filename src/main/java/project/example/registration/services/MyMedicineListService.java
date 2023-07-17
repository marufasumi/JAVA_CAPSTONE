package project.example.registration.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.registration.entities.MyMedicineList;
import project.example.registration.repositories.MyMedicineRepository;

import java.util.List;

@Service
public class MyMedicineListService {


    @Autowired
    private MyMedicineRepository myMedicineRepository;


    public void saveMyMedicines(MyMedicineList myMedicineList) {
        myMedicineRepository.save(myMedicineList);
    }

    public List<MyMedicineList> getAllMyMedicines(){

        return myMedicineRepository.findAll();
    }

    public void deleteById(int id){
        myMedicineRepository.deleteById(id);

    }

}