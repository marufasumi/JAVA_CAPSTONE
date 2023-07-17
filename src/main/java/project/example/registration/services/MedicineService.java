package project.example.registration.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.registration.entities.Medicine;
import project.example.registration.repositories.MedicineRepository;

import java.util.List;


@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository; //book repository obj needed to call the save method
    public void save(Medicine medicine){  // to save medicine into our database

        medicineRepository.save(medicine);
    }

    public List<Medicine> getAllMedicines(){

        return medicineRepository.findAll();


    }

    public Medicine getMedicineById(int id){
        return medicineRepository.findById(id).get();


    }

    public void deleteById(int id){
        medicineRepository.deleteById(id);
    }
}
