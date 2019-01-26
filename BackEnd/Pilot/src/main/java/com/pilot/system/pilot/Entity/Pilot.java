package com.pilot.system.pilot.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pilot")
@Data
@NamedQueries(
        {@NamedQuery(name = "findAll", query = "select p from Pilot p"),
        @NamedQuery(name = "findByDate", query = "select p from Pilot p where p.dateCreated = :date"),
        @NamedQuery(name = "findByName", query = "select p from Pilot p where p.name like :name")}
        )
@Getter
@Setter
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date dateCreated;


    public Pilot() {
    }

    public Pilot(String name, Date dateCreated) {
        this.name = name;
        this.dateCreated = dateCreated;
    }
}
