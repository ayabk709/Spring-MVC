package net.aya.tp3partie1;

import net.aya.tp3partie1.Entities.Patient;
import net.aya.tp3partie1.Repisitory.PatientRepisitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Tp3partie1Application implements CommandLineRunner {
@Autowired
   private PatientRepisitory patientRepisitory;
    public static void main(String[] args) {
        SpringApplication.run(Tp3partie1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      /*  patientRepisitory.save(new Patient(null, "Aya", new Date(), false, 10));
        patientRepisitory.save(new Patient(null, "bk", new Date(), true, 20));
        patientRepisitory.save(new Patient(null, "Ali", new Date(), false, 30));


*/



/*Patient patient1 = new Patient();
patient1.setId(null);
patient1.setNom("Aya");
patient1.setMalade(false);
patient1.setDateNaissance(new Date());
patient1.setScore(10);

Patient patient2 = new Patient(null, "Mohamed", new Date(), false, 20);
//builder
Patient patient3 = Patient.builder()
        .nom("Ali")
        .dateNaissance(new Date())
        .malade(true)
        .score(30)
        .build();*/


            }
}
