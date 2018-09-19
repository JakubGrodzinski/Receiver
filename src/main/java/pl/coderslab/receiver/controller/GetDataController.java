package pl.coderslab.receiver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.receiver.DTO.CountryDto;
import pl.coderslab.receiver.converter.CountryConverter;
import pl.coderslab.receiver.model.Country;
import pl.coderslab.receiver.repository.CountryRepository;
import pl.coderslab.receiver.service.ReceiveDataService;

import java.util.HashSet;


@Controller
@RequestMapping("/user")
public class GetDataController
{
    @Autowired
    ReceiveDataService receiveDataService;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CountryConverter countryConverter;


    @RequestMapping("/get-countries")
    @ResponseBody
    public String getCountriesAction()
    {
        CountryDto[] countries = receiveDataService.receivedCountries();
        for (CountryDto countryDto: countries)
        {
            Country country = countryConverter.convert(countryDto);
            countryRepository.save(country);
        }
        return "Hello from the other side";
    }
}
