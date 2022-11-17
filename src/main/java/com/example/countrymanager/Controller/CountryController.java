package com.example.countrymanager.Controller;
import com.example.countrymanager.Repository.CountryRepository;
import com.example.countrymanager.Service.CountryService;
import com.example.countrymanager.model.Country;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")

public class CountryController {

    @Autowired
    private CountryService countryService;


    @GetMapping("country")
    public List<Country> getAllCountry() {
        return this.countryService.getAllCountry();
    }



    @GetMapping
    @RequestMapping("{id}")
    public Optional<Country> getContrybyId(@PathVariable Long id) {
        return this.countryService.getCountrybyId(id);
    }


    @PostMapping(value = "add",consumes = "*/*")
    public Country addCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        countryService.deleteById(id);
    }



    @RequestMapping(value = "{id}",consumes = "*/*" ,method = RequestMethod.PUT)
    public Country updateCountry(@PathVariable Long id,  @RequestBody Country country) {
        Country ec = countryService.getCountrybyId(id).get();
        ec.setCountryname(country.getCountryname());
        ec.setDbupdatedate(country.getDbupdatedate());
        ec.setNationallanguage(country.getNationallanguage());
        ec.setPopulation(country.getPopulation());

        return countryService.updateCountry(id,ec);
    }
}
