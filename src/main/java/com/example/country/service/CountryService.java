package com.example.country.service;

import com.example.country.GetCountryRequest;
import com.example.country.GetCountryResponse;
import com.example.country.repository.CountryRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryService {

    private final CountryRepository countryRepository;
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    private static  final String NAMESPACE_URI = "http://com.example/country";

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request){

        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return  response;

    }
}
