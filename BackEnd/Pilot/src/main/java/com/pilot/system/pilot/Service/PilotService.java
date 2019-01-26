package com.pilot.system.pilot.Service;

import com.pilot.system.pilot.DTO.PilotDto;

import java.text.ParseException;
import java.util.List;

public interface PilotService {

    PilotDto getPilotById(Integer id);

    void insertPilot(PilotDto pilotDto);

    void updatePilot(Integer id, PilotDto pilotDto);

    List<PilotDto> getAllPilots();

    List<PilotDto> getAllByDate(String date) throws ParseException;

    List<PilotDto> getAllByName(String name);

    void deleteById(Integer id);
}
