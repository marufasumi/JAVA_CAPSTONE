package project.example.registration.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.example.registration.entities.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Integer> {


}
