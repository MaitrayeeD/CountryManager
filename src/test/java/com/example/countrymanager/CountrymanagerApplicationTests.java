package com.example.countrymanager;


import com.example.countrymanager.Repository.CountryRepository;
import com.example.countrymanager.model.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountrymanagerApplicationTests {

	@Autowired
	private CountryRepository countryRepository;
	Country country;
	@Test
	void getAllCountry() {
		List<Country>list=countryRepository.findAll();
		assertThat(list).size().isGreaterThan(0);

	}

	@Test
	void getContrybyId() {
		country=countryRepository.findById(7L).get();
		assertEquals("China",country.getCountryname());
	}

	@Test
	void addCountry() {
		country=new Country();
		country.setId(7L);
		country.setCountryname("China");
		country.setPopulation((float)89.89);
		country.setNationallanguage("Chinease(mandarin)");
		country.setDbupdatedate(LocalDate.parse("2022-07-04"));
		countryRepository.save(country);
		assertNotNull(countryRepository.findById(7L).get());
	}

	@Test
	void delete() {
		countryRepository.deleteById(6L);
		assertThat(countryRepository.existsById(6L)).isFalse();
	}

	@Test
	void updateCountry() {
		country=countryRepository.findById(6L).get();
		country.setCountryname("Germany");
		countryRepository.save(country);
		assertNotEquals("Spain",countryRepository.findById(6L).get().getCountryname());
	}


}
