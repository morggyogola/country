package com.example.country.repository;
import com.example.country.Country;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class CountryRepository {
    private final Map<String,Country> countries = new HashMap<>();
}
