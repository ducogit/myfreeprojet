package com.example.logement10.Controller;

import com.example.logement10.Entity.*;
import com.example.logement10.Repository.*;
import com.example.logement10.Services.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
public class WebRestController {
    @Autowired ResidenceRepository residenceRepository;
    @Autowired BlocRepository blocRepository;
    @Autowired Chambrerepository chambrerepository;
    @Autowired TypeBlocRepository typeBlocRepository;
    @Autowired FonctionRepository fonctionRepository;
    @Autowired EmployerRepository employerRepository;

    @PostMapping("/SaveResidence")
    public ResponseEntity<Object> enregistrerResidence(@RequestBody Residence residence){
        residenceRepository.save(residence);
        List<Residence> residenceList = residenceRepository.findAll(Sort.by("dateResidence").descending());
        ServiceResponse<List<Residence>> response = new ServiceResponse<>("success",residenceList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getResidence")
    public ResponseEntity<Object> selectResidence(){
        List<Residence> residenceList = residenceRepository.findAll(Sort.by("dateResidence").descending());
        ServiceResponse<List<Residence>> response = new ServiceResponse<>("success",residenceList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/SaveBloc")
    public ResponseEntity<Object> enregistrerBloc(@RequestBody Bloc bloc){

        List<Bloc> blocList = blocRepository.findAll(Sort.by("dateBloc").descending());
        if (blocList.size() == 0){
            bloc.setCodeBloc("300");
            blocRepository.save(bloc);
        }
        else {
            long id = (blocList.get(0).getIdBloc()) + 300;
            String id1 = String.valueOf(id);
            bloc.setCodeBloc(id1);
            blocRepository.save(bloc);
        }
        for (int i=1;i<=bloc.getNbrChambreBloc();i++) {
            chambrerepository.save(new Chambre(i,bloc.getCapaciteChambre(), bloc.getCapaciteChambre(), bloc.getNomBloc(),new Date()));
        }

        List<Bloc> blocList1 = blocRepository.findAll(Sort.by("dateBloc").descending());
        ServiceResponse<List<Bloc>> response = new ServiceResponse<>("success",blocList1);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllBloc")
    public ResponseEntity<Object> tousLesBloc(){
        List<Bloc> blocList1 = blocRepository.findAll(Sort.by("dateBloc").ascending());
        ServiceResponse<List<Bloc>> response = new ServiceResponse<>("success",blocList1);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/SaveChambre")
    public ResponseEntity<Object> enregistrerChambre(@RequestBody Chambre chambre){
        chambrerepository.save(chambre);
        List<Chambre> chambreList = chambrerepository.findAll(Sort.by("dateChambre").ascending());
        ServiceResponse<List<Chambre>> response = new ServiceResponse<>("success",chambreList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllResidence")
    public ResponseEntity<Object> selectTypeResidence(){
        List<Residence> residenceList = residenceRepository.findAll();
        ServiceResponse<List<Residence>> response = new ServiceResponse<>("success",residenceList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/getAllBlocName")
    public ResponseEntity<Object> selectTypeBloc(){
        List<Bloc> blocList = blocRepository.findAll();
        ServiceResponse<List<Bloc>> response = new ServiceResponse<>("success",blocList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/getAllChambre")
    public ResponseEntity<Object> selectAllChambre(){
        List<Chambre> chambreList = chambrerepository.findAll();
        ServiceResponse<List<Chambre>> response = new ServiceResponse<>("success",chambreList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/getByTypeBloc")
    public ResponseEntity<Object> selectTousParType(@RequestParam(name = "type",defaultValue = "")String type){
        System.out.println("type : "+type);
        String type1 = "";
        if (type.contains(" ")){
            type1 = type.replace(" ","+");
        }
        else {
            type1 = type;
        }
        List<Chambre> chambreList0 = new ArrayList<>();
        List<Chambre> chambreList = chambrerepository.findAll(Sort.by("dateChambre").ascending());
        for (Chambre chambre:chambreList) {
            String bloc = chambre.getNomBloc();
            Bloc bloc1 = blocRepository.findBlocByNomBloc(bloc);
            System.out.println("type + : "+type1);
            if (bloc1.getTypeBloc().equals(type1)){
                chambreList0.add(chambre);
            }
        }
        for (Chambre chambre1:chambreList0){
            System.out.println("Chambre : "+chambre1.getNomBloc());
        }
        ServiceResponse<List<Chambre>> response = new ServiceResponse<>("success",chambreList0);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetAllChambreByBloc")
    public ResponseEntity<Object> tousLesChambresParBloc(@RequestParam(name = "nomBloc",defaultValue = "") String nomBloc){
        System.out.println("nomBloc : "+nomBloc);
        List<Chambre> chambreList0 = new ArrayList<>();
        List<Chambre> chambreList = chambrerepository.findAllByNomBlocOrderByNumeroChambreAsc(nomBloc);
        for (Chambre chambre:chambreList){
            if (chambre.getNbrPlaceLibre() != 0){
                chambreList0.add(chambre);
                System.out.println("chambre num : "+chambre.getNumeroChambre());
            }
        }
        System.out.println("size : "+chambreList.size());
        ServiceResponse<List<Chambre>> response = new ServiceResponse<>("success",chambreList0);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/SaveBlocTypeC")
    public ResponseEntity<Object> saveBlocTypeCh(@RequestBody TypeBloc typeBloc){
        List<TypeBloc> typeBlocList = typeBlocRepository.findAll(Sort.by("dateTypeBloc").descending());
        if (typeBlocList.size() == 0){
            String code = "100";
            typeBloc.setCodeTypeBloc(code);
        }
        else {
            String code1 = String.valueOf((typeBlocList.get(0).getIdType()) + 100);
            typeBloc.setCodeTypeBloc(code1);
        }
        typeBlocRepository.save(typeBloc);
        List<TypeBloc> typeBlocList1 = typeBlocRepository.findAll();
        ServiceResponse<List<TypeBloc>> response = new ServiceResponse<>("success",typeBlocList1);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetAllType")
    public ResponseEntity<Object> selectTousLesTypes(){
        List<TypeBloc> typeBlocList = typeBlocRepository.findAll();
        ServiceResponse<List<TypeBloc>> response = new ServiceResponse<>("success",typeBlocList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/SaveFonction")
    public ResponseEntity<Object> saveFonction(@RequestBody Fonction fonction){
        List<Fonction> fonctionList = fonctionRepository.findAll(Sort.by("dateFonction").descending());
        if (fonctionList.size() == 0){
            String code = "600";
            fonction.setCodeFonction(code);
        }
        else {
            String code1 = String.valueOf((fonctionList.get(0).getCodeFonction()) + 600);
            fonction.setCodeFonction(code1);
        }
        fonctionRepository.save(fonction);
        List<Fonction> fonctionList1 = fonctionRepository.findAll();
        ServiceResponse<List<Fonction>> response = new ServiceResponse<>("success",fonctionList1);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetAllFonction")
    public ResponseEntity<Object> selectTousLesFonctions(){
        List<Fonction> fonctionList = fonctionRepository.findAll();
        ServiceResponse<List<Fonction>> response = new ServiceResponse<>("success",fonctionList);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @PostMapping("/SaveEmployer")
    public ResponseEntity<Object> saveEmployer(@RequestBody Employer employer){
        List<Employer> employerList = employerRepository.findAll(Sort.by("dateEmployer").descending());
        employerRepository.save(employer);
        List<Employer> employerList1 = employerRepository.findAll();
        ServiceResponse<List<Employer>> response = new ServiceResponse<>("success",employerList1);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetAllEmployer")
    public ResponseEntity<Object> getAllEmployers(){
        List<Employer> employerList1 = employerRepository.findAll();
        ServiceResponse<List<Employer>> response = new ServiceResponse<>("success",employerList1);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetNbrResidence")
    public ResponseEntity<Object> getNbrResidence(){
        List<Residence> residenceList = residenceRepository.findAll();
        ServiceResponse<Integer> response = new ServiceResponse<>("success",residenceList.size());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetNbrBloc")
    public ResponseEntity<Object> getNbrBloc(){
        List<Bloc> blocList = blocRepository.findAll();
        ServiceResponse<Integer> response = new ServiceResponse<>("success",blocList.size());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/GetNbrChambre")
    public ResponseEntity<Object> getNbrChambre(){
        List<Chambre> chambreList = chambrerepository.findAll();
        int nbrCha = chambreList.size();
        List<Chambre> chambreList1 = chambrerepository.findAllByNbrPlaceLibre(4);
        int nbrChaL = chambreList1.size();
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("nbrChaL",nbrChaL);
        modelMap.addAttribute("nbrCha",nbrCha);
        ServiceResponse<ModelMap> response = new ServiceResponse<>("success",modelMap);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @GetMapping("/GetUserAuthentic")
    public ResponseEntity<Object> selectUtilisateurAuthentifier(@RequestParam(name = "nomU",defaultValue = "") String nomU){
        String existence = "";
        ServiceResponse<Object> response = null;
        Employer utilisateur = employerRepository.findEmployerByPseudoEmployer(nomU);
        if (utilisateur != null){
            existence = utilisateur.getPrenomEmployer();
            response = new ServiceResponse<>("success",utilisateur);
        }
        else {
            System.out.println("User : "+nomU+" n'existe pas");
            existence = "NonExiste";
            response = new ServiceResponse<>("success",existence);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
