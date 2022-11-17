package com.example.countrymanager.Service;
import com.example.countrymanager.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    public List<Country> getAllCountry();
    public Optional<Country> getCountrybyId(Long id);

    public Country addCountry(Country country);
    public Country deleteById(Long id);
    public Country updateCountry(Long id,Country country);
}
