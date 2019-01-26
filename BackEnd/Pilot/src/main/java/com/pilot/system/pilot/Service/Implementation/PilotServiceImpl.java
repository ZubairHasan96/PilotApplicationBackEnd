package com.pilot.system.pilot.Service.Implementation;

import com.pilot.system.pilot.DTO.PilotDto;
import com.pilot.system.pilot.Entity.Pilot;
import com.pilot.system.pilot.Factory.PilotFactory;
import com.pilot.system.pilot.Repository.PilotRepository;
import com.pilot.system.pilot.Service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {

    @Autowired
    PilotRepository pilotRepository;

    public PilotDto getPilotById(Integer id){
        Pilot pilot = pilotRepository.get(id);
        return PilotFactory.getPilotDtoFromPilot(pilot);
    }

    public void insertPilot(PilotDto pilotDto) {
        pilotRepository.save(
                PilotFactory.getPilotFromPilotDto(pilotDto)
        );
    }

    public void updatePilot(Integer id ,PilotDto pilotDto) {
        Pilot pilot = pilotRepository.get(id);
        pilot.setDateCreated(pilotDto.getDateCreated());
        pilot.setName(pilotDto.getName());
        pilotRepository.save(pilot);
    }

    public List<PilotDto> getAllPilots() {
        List<Pilot> allPilots = pilotRepository.getAll();
        List<PilotDto> allPilotsDto = new LinkedList<>();
        for(Pilot pilot : allPilots){
            allPilotsDto.add(PilotFactory.getPilotDtoFromPilot(pilot));
        }
        return allPilotsDto;
    }


    public List<PilotDto> getAllByDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("d-M-yyyy");
        Date _date = format.parse(date);
        List<Pilot> allPilotsByDate = pilotRepository.getAllByDate(_date);
        List<PilotDto> pilotsDtoByDate = new LinkedList<>();
        for(Pilot pilot : allPilotsByDate) {
            pilotsDtoByDate.add(PilotFactory.getPilotDtoFromPilot(pilot));
        }

        return pilotsDtoByDate;
    }

    public List<PilotDto> getAllByName(String name){
        List<Pilot> allPilotsByName = pilotRepository.getAllByName(name);
        List<PilotDto> pilotsDtoByName = new LinkedList<>();
        for(Pilot pilot : allPilotsByName) {
            pilotsDtoByName.add(PilotFactory.getPilotDtoFromPilot(pilot));
        }

        return pilotsDtoByName;
    }

    public void deleteById(Integer id) {
        pilotRepository.deleteById(id);
    }
}

