package net.aya.tp3partie1.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.aya.tp3partie1.Entities.Patient;
import net.aya.tp3partie1.Repisitory.PatientRepisitory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Binding;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepisitory patientRepisitory;

    @GetMapping("/index")
    //obligatoir de mettre la page et size
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "3") int size,
                        @RequestParam(name = "motCle", defaultValue = "") String motCle, @RequestParam(name = "malade", required = false) Boolean malade) {
        //ici in peut transmettre la page qu'on veut
        /* Page<Patient> pagepatient=patientRepisitory.findAll(PageRequest.of(page,size));
         */
        Page<Patient> pagepatient;
        if (malade != null) {
            // Filtrer par statut de maladie si le paramètre est présent
            pagepatient = patientRepisitory.findByMalade(malade, PageRequest.of(page, size));

        } else {
            // Filtrer par nom si le paramètre est présent
            pagepatient = patientRepisitory.findByNomContains(motCle, PageRequest.of(page, size));
        }

        model.addAttribute("patients", pagepatient.getContent());

        //retourne le  nbr total des pages
        model.addAttribute("page", new int[pagepatient.getTotalPages()]);
        model.addAttribute("currentPage", page);


        model.addAttribute("motCle", motCle);
        model.addAttribute("malade", malade);

        /*   List<Patient> pt=patientRepisitory.findAll();*/
        /*  model.addAttribute("patients",pt);*/


        //vue patients
        return "Patients";


    }

    //supprimer un patient
    @GetMapping("/delete")
    public String delete(Long id, String motCle, int page) {
        patientRepisitory.deleteById(id);
//car on a supprimé un patient on doit rester sur la meme page ,el le mot doit tre afficher dans le input
        return "redirect:/index?page=" + page + "&motCle=" + motCle;
    }


    /////filtre apr malade


    @GetMapping("/formPatients")
    public String formPatients(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }
    @GetMapping("/editPatients")
    public String editPatients(Model model, Long id, String motCle, int page) {
        Patient patient = patientRepisitory.findById(id).orElse(null);
        if (patient == null) throw new RuntimeException("Patient introuvable");
        model.addAttribute("patient", patient);
        model.addAttribute("page", page);
        model.addAttribute("motCle", motCle);
        return "editPatients";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formPatients"; // Return the same form with validation errors
        }
        patientRepisitory.save(patient);
        // Redirect to the index page after saving
        return "redirect:/index";
    }
    @PostMapping("/savee")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(name = "page", defaultValue = "0") int page,
                       @RequestParam(name = "motCle", defaultValue = "") String motCle) {
        if (bindingResult.hasErrors()) {
            return "editPatients"; // Return the same form with validation errors
        }
        patientRepisitory.save(patient);
        // Redirect to the index page after saving
        return "redirect:/index?page=" + page + "&motCle=" + motCle;
    }


}
