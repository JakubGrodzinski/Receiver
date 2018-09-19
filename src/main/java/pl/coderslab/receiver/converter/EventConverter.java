package pl.coderslab.receiver.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.receiver.DTO.EventDto;
import pl.coderslab.receiver.model.Event;
@Component
public class EventConverter implements Converter<EventDto, Event>
{
    @Override
    public Event convert(EventDto eventDto)
    {
        Event event = new Event();
        event.setTeam1(eventDto.getTeam1());
        event.setTeam2(eventDto.getTeam2());
        event.setTeam1score(eventDto.getTeam1score());
        event.setTeam2score(eventDto.getTeam2score());
        event.setBeginning(eventDto.getBeginning());
        event.setEnd(eventDto.getEnd());
        return event;
    }
}
