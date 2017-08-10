package ru.fedorenko.Beans;

import ru.fedorenko.Domain.AircraftEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ivan on 28.05.17.
 */
@Stateless
public class AirBean {
    @PersistenceContext(unitName = "demoDS")
    private EntityManager manager;

    public boolean newAir (String aircraft_code, String model, Integer range)
    {
        if (aircraft_code.isEmpty() || model.isEmpty() || range.toString().isEmpty())
        {
            return false;
        }

        AircraftEntity air_code = manager.find(AircraftEntity.class, aircraft_code);
        if (air_code != null)
        {
            return false;
        }

        AircraftEntity air_model = manager.find(AircraftEntity.class, model);
        if (air_model != null)
        {
            return false;
        }

        AircraftEntity newAir = new AircraftEntity();
        newAir.setAircraft_code(aircraft_code);
        newAir.setModel(model);
        newAir.setRange(range);

        manager.persist(newAir);
        return true;
    }

    public AircraftEntity findValue(String air)
    {
        return manager.find(AircraftEntity.class, air);
    }
    public List<AircraftEntity> getAll(){
        TypedQuery<AircraftEntity> query = manager.createNamedQuery("AirAll",AircraftEntity.class);
        return query.getResultList();
    }

    public void updateAircraft(AircraftEntity aircraftEntity)
    {
        manager.merge(aircraftEntity);
    }

    public void removeAircraft(AircraftEntity aircraftEntity)
    {
        AircraftEntity aircraftEntity1 = manager.merge(aircraftEntity);
        manager.remove(aircraftEntity1);
    }
}
