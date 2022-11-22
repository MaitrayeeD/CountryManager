package com.example.countrymanager.Repository;
import com.example.countrymanager.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface CountryRepository extends JpaRepository<Country,Long> {
    void delete(Long id);
}
