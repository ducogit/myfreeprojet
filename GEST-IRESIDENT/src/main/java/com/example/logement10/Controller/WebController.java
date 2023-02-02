package com.example.logement10.Controller;

import com.example.logement10.Entity.Bloc;
import com.example.logement10.Entity.Chambre;
import com.example.logement10.Entity.Insription;
import com.example.logement10.Entity.Resident;
import com.example.logement10.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.SchedulingConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Controller
public class WebController {
    @Autowired BlocRepository blocRepository;
    @Autowired ResidenceRepository residenceRepository;
    @Autowired ResidentRepository residentRepository;
    @Autowired Chambrerepository chambrerepository;
    @Autowired InscriptionRepository inscriptionRepository;
    @Autowired TransfertRepository transfertRepository;

    @GetMapping("/")
    public String dashBoard0(Model model){
        return "redirect:Identifier";
    }

    @GetMapping("/Identifier")
    public String identifierPage(){
        return "/identifier";
    }

    @GetMapping("/Accueil")
    public String accueilPage(Model model){
        return "accueil";
    }

    @GetMapping("/E-Log")
    public String dashBoard(Model model){
        return "dashBoard";
    }

    @GetMapping("/Transfert")
    public String transfertPage(Model model){
        return "Transfert/Transfert";
    }

    @GetMapping("/Resident")
    public String residentPage(Model model){
        List<Resident> residentList = residentRepository.findAll(Sort.by("dateResident").ascending());
        model.addAttribute("residentList",residentList);
        model.addAttribute("resident",new Resident());

        List<Bloc> blocList = blocRepository.findAll(Sort.by("dateBloc").ascending());
        model.addAttribute("blocList",blocList);
        model.addAttribute("bloc",new Bloc());
        return "Resident/Resident";
    }

    @GetMapping("/Residence")
    public String residencePage(Model model){
        return "Residence/Residence";
    }

    @GetMapping("/Inscription")
    public String inscriptionPage(Model model){
        List<Bloc> blocList = blocRepository.findAll();
        model.addAttribute("blocList",blocList);
        model.addAttribute("bloc",new Bloc());
        return "Inscription/Inscription";
    }

    @PostMapping("/SaveInscription")
    public String enregistrerInscription(@RequestParam(name = "inputNomResident",defaultValue = "") String inputNomResident,
                                         @RequestParam(name = "inputPrenomResident",defaultValue = "") String inputPrenomResident,
                                         @RequestParam(name = "sexeResident",defaultValue = "") String sexeResident,
                                         @RequestParam(name = "dateNaisse",defaultValue = "") String dateNaisse,
                                         @RequestParam(name = "lieuNaisse",defaultValue = "") String lieuNaisse,
                                         @RequestParam(name = "adresseResident",defaultValue = "") String adresseResident,
                                         @RequestParam(name = "nationaliteResident",defaultValue = "") String nationaliteResident,
                                         @RequestParam(name = "photoResident",defaultValue = "") MultipartFile photoResident,
                                         @RequestParam(name = "filiereResident",defaultValue = "") String filiereResident,
                                         @RequestParam(name = "serieBacc",defaultValue = "") String serieBacc,
                                         @RequestParam(name = "anneeBacc",defaultValue = "") String anneeBacc,
                                         @RequestParam(name = "nomBloc",defaultValue = "") String nomBloc,
                                         @RequestParam(name = "numeroChambre",defaultValue = "") int numeroChambre,
                                         @RequestParam(name = "anneeInscription",defaultValue = "") String anneeInscription) throws ParseException {


        Date dateNaissanse = new SimpleDateFormat("yyyy-MM-dd").parse(dateNaisse);
        String photo = null;
        try {
            photo = Base64.getEncoder().encodeToString(photoResident.getBytes());
        }
        catch (IOException e){
            e.printStackTrace();
        }

        Chambre chambre = chambrerepository.findChambreByNumeroChambreAndNomBloc(numeroChambre,nomBloc);
        System.out.println("Chambre 0 plc libre : "+ chambre.getNbrPlaceLibre());
        if (chambre.getNbrPlaceLibre() > 0){
            int nbrCh = chambre.getNbrPlaceLibre() - 1;
            chambre.setNbrPlaceLibre(nbrCh);
            System.out.println("Chambre 1 plc libre : "+ nbrCh);
            chambrerepository.save(chambre);
        }
        residentRepository.save(new Resident(inputNomResident,
                inputPrenomResident,
                sexeResident,
                dateNaissanse,
                lieuNaisse,
                adresseResident,
                nationaliteResident,
                photo,
                filiereResident,
                serieBacc,
                anneeBacc,new Date()));

        inscriptionRepository.save(new Insription(anneeInscription,
                "Complet",
                numeroChambre,
                nomBloc,
                inputNomResident+" "+inputPrenomResident,
                "Trinito",
                new Date()));

        return "redirect:Inscription";
    }

    @GetMapping("/Employer")
    public String employerPage(Model model){
        return "Employer/Employer";
    }

    @GetMapping("/Chambre")
    public String chambrePage(Model model){
        return "Chambre/Chambre";
    }

    @GetMapping("/Bloc")
    public String blocPage(Model model){
        return "Bloc/Bloc";
    }
}
