package project.example.registration.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.example.registration.entities.MyMedicineList;

@Repository
public interface MyMedicineRepository extends JpaRepository<MyMedicineList,Integer> {

}
