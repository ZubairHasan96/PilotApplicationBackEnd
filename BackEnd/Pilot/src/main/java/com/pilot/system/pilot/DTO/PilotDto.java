package com.pilot.system.pilot.DTO;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@Getter
@Setter
@JsonAutoDetect
public class PilotDto implements Serializable {

    private Integer id;

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Asia/Karachi")
    private Date dateCreated;

    public PilotDto(String name, Date dateCreated) {
        this.name = name;
        this.dateCreated = dateCreated;
    }

}
