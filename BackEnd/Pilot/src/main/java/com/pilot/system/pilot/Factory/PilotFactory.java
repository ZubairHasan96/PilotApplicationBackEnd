package com.pilot.system.pilot.Factory;

import com.pilot.system.pilot.DTO.PilotDto;
import com.pilot.system.pilot.Entity.Pilot;

public class PilotFactory {

    public static PilotDto getPilotDtoFromPilot(Pilot pilot){
        return new PilotDto(
                pilot.getId(),
                pilot.getName(),
                pilot.getDateCreated()
        );
    }

    public static Pilot getPilotFromPilotDto(PilotDto pilotDto){
        return new Pilot(
                pilotDto.getName(),
                pilotDto.getDateCreated());
    }
}
