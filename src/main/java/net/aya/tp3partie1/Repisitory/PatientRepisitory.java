package net.aya.tp3partie1.Repisitory;

import net.aya.tp3partie1.Entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//dao
public interface PatientRepisitory extends JpaRepository<Patient, Long> {
    //on respecte la convention
    //obligatoir de mettre la clas spageable car c est de type page
Page<Patient> findByNomContains(String nom , Pageable pageable);
Page<Patient> findByMalade(boolean malade,Pageable pageable);


/*@Query("select p from Patient p where p.nom like :x")
Page<Patient> search(@Param("x") String nom,Pageable pageable);*/



}
