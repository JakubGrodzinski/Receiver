package pl.coderslab.receiver.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.receiver.DTO.CountryDto;
import pl.coderslab.receiver.model.Country;
import pl.coderslab.receiver.model.League;

@Component
public class CountryConverter implements Converter <CountryDto, Country>
{
    @Override
    public Country convert(CountryDto countryDto)
    {
        Country country = new Country();
        country.setName(countryDto.getName());
        for (League league : countryDto.getLeagues())
        {
            league.setId(null);
        }
        return country;
    }
}
