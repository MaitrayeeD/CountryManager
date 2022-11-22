package com.example.countrymanager;


import com.example.countrymanager.Repository.CountryRepository;
import com.example.countrymanager.Service.CountryService;
import com.example.countrymanager.model.Country;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CountrymanagerApplicationTests {
private MockMvc mockMvc;
	@Autowired
	private CountryService countryService;
	@MockBean
	private CountryRepository countryRepository;
	Country country;
	@Test
	void getAllCountry() {
		when(countryRepository.findAll()).thenReturn(Stream.
				of(new Country(5L,"Thai","Thai",68f,LocalDate.parse("2022-11-07")),new Country(9L,"India","Hindi",123.5f,LocalDate.parse("2022-11-01"))).collect(Collectors.toList()));
		assertEquals(2,countryService.getAllCountry().size());

	}

	@Test
	void getContrybyId() {
		Long id=9L;
		countryService.getCountrybyId(id);
		verify(countryRepository,times(1)).findById(9L);
	}

	@Test
	void addCountry() {
		country=new Country(9L,"India","Hindi",123.5f,LocalDate.parse("2022-11-01"));
        when(countryRepository.save(country)).thenReturn(country);
		assertEquals(country,countryService.addCountry(country));
	}

	@Test
	void delete() {
	Long id=10L;
	countryService.deleteById(id);
	verify(countryRepository,times(1)).delete(id);
	}

	@Test
	void updateCountry() {
		Long id=9L;
		country=new Country(9L,"India","Hindi",123.5f,LocalDate.parse("2022-11-01"));
		when(countryRepository.save(country)).thenReturn(country);
		assertEquals(country,countryService.updateCountry(id,country));
	}


}
