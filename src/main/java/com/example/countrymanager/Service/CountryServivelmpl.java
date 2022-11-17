package com.example.countrymanager.Service;

import antlr.StringUtils;
import com.example.countrymanager.model.Country;
import com.example.countrymanager.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CountryServivelmpl implements CountryService{
    @Autowired
    private CountryRepository countryRepository;


    public CountryServivelmpl() {
    }


    @Override
    public List<Country> getAllCountry() {
        return countryRepository.findAll();

    }

    @Override
    public Optional<Country> getCountrybyId(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country addCountry(Country country) {
        countryRepository.save(country);
        return country;
    }

    @Override
    public Country deleteById(Long id) {
        Country c = countryRepository.getOne(id);
        countryRepository.delete(c);
        return null;
    }

    @Override
    public Country updateCountry(Long id, Country country) {
        if (countryRepository.existsById(id)) {
            countryRepository.save(country);


        }
        return country;
    }


}
