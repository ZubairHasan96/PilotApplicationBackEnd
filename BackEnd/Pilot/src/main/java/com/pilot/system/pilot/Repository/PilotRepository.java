package com.pilot.system.pilot.Repository;

import com.pilot.system.pilot.Entity.Pilot;
import com.pilot.system.pilot.Repository.Generic.GenericRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.Queue;

@Repository
public class PilotRepository extends GenericRepository<Pilot> {

    public List<Pilot> getAll(){
            TypedQuery<Pilot> allPilots = entityManager.createNamedQuery("findAll", Pilot.class);
        return allPilots.getResultList();
    }

    public List<Pilot> getAllByDate(Date date){
        TypedQuery<Pilot> allPilots = entityManager.createNamedQuery("findByDate", Pilot.class).setParameter("date",date);
        return allPilots.getResultList();
    }

    public List<Pilot> getAllByName(String name){
        TypedQuery<Pilot> allPilots = entityManager.createNamedQuery("findByName", Pilot.class).setParameter("name","%" + name + "%" );
        return allPilots.getResultList();
    }

    public void deleteById (Integer id) {
        Query deleteById = entityManager.createQuery("delete from Pilot p where p.id like " + id);
        deleteById.executeUpdate();
    }
}
