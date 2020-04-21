package com.mypersonal.corona.api;

import com.mypersonal.corona.model.Corona;
import com.mypersonal.corona.service.CoronaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corona")
public class CoronaController {
    @Autowired
    private CoronaService service;
    @GetMapping("/showDetails")
    public List<Corona> getListOfDetails()
    {
        return service.getAll();
    }
    @GetMapping("/showDetails1/{countryName}")
    public List<Corona> getListOfAffectedOnesGreaterThan(@PathVariable("countryName") String countryName)
    {
        return service.getAffectedWithCountry(countryName);
    }

    @GetMapping("/showDetails2/{affected}")
    public List<Corona> getAllAffected(@PathVariable("affected") int affected)
    {
        return service.getAffectedWithCondition(affected);
    }
    @GetMapping("/getCount")
    public String getNoOfCountryAffectedTllDate()
    {
        return service.getNoOfCountryAffected();
    }

    @DeleteMapping("/deleteCountryDetails/{countryName}")
    public List<Corona> DeletingCountryDetails(@PathVariable("countryName") String countryName)
    {
         return service.DeleteCornaAffectedCountryByName(countryName);
    }
    @GetMapping("/showConditionalDetails/{countryName}/{affected}")
    public List<Corona>  showConditionalDetails(@PathVariable String countryName,@PathVariable int affected)
    {
        return service.showDetailsOfCountryWithSameNameAndAffectedRate(countryName,affected);
    }
    @GetMapping("/showSortedList/{field}")
    public List<Corona> getSortedList(@PathVariable String field)
    {
        return service.getSort(field);
    }

    @GetMapping("getCustomQuerry")
    public List<Corona> getCutomizeQuerry()
    {
        return service.getCustomizationQuerry();
    }


}
