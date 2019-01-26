package com.pilot.system.pilot.Controller;

import com.pilot.system.pilot.DTO.PilotDto;
import com.pilot.system.pilot.Service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pilot/")
public class PilotController {

    @Autowired
    PilotService pilotService;

    @RequestMapping(value = "getPilot/{id}" ,method = RequestMethod.GET)
    public @ResponseBody
    PilotDto getPilotById(
            @PathVariable("id") Integer id ){
        return pilotService.getPilotById(id);
    }

    @RequestMapping(value = "editPilot/{id}" ,method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePilot(@PathVariable("id") Integer id ,@RequestBody PilotDto sourceItem){
        pilotService.updatePilot(id ,sourceItem);
    }


    @RequestMapping(value = "insertPilot" ,method = RequestMethod.POST, headers = {"content-type=application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public void insertPilot(
            @RequestBody PilotDto pilot ){
        pilotService.insertPilot(pilot);
    }

    @RequestMapping(value = "getAllPilots" ,method = RequestMethod.GET)
    public @ResponseBody
    List<PilotDto> getAllPilot(){
        return pilotService.getAllPilots();
    }

    @RequestMapping(value = "getPilot/date/{date}" ,method = RequestMethod.GET)
    public @ResponseBody
    List<PilotDto> getAllByDate(
            @PathVariable("date") String date ) throws ParseException {
        return pilotService.getAllByDate(date);
    }

    @RequestMapping(value = "getPilot/name/{name}" ,method = RequestMethod.GET)
    public @ResponseBody
    List<PilotDto> getAllByName(
            @PathVariable("name") String name ){
        return pilotService.getAllByName(name);
    }

    @RequestMapping(value = "deletePilot/{id}" ,method = RequestMethod.DELETE)
    public void deleteById(
            @PathVariable("id") Integer id ){
                pilotService.deleteById(id);
    }
}
