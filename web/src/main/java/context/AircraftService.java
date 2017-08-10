package context;

import ru.fedorenko.Beans.AirBean;
import ru.fedorenko.Domain.AircraftEntity;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ivan on 28.05.17.
 */
@Named("AirCDI")
@SessionScoped
public class AircraftService implements Serializable{
    private String aircraft_code;
    private String model;
    private String range;
    private boolean createSuccess;
    private AircraftEntity aircraftEntity;
    @EJB(mappedName = "AirBean")
    private AirBean airBean;

    public String getAircraft_code() {
        return aircraft_code;
    }

    public void setAircraft_code(String aircraft_code) {
        this.aircraft_code = aircraft_code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public boolean isCreateSuccess() {
        return createSuccess;
    }

    public void setCreateSuccess(boolean createSuccess) {
        this.createSuccess = createSuccess;
    }

    public AircraftEntity getAircraftEntity() {
        return aircraftEntity;
    }

    public void setAircraftEntity(AircraftEntity aircraftEntity) {
        this.aircraftEntity = aircraftEntity;
    }

    public AircraftEntity editAircraft(String aircraft_code) {
        return  airBean.findValue(aircraft_code);
    }

    public void createAircraft(String aircraft_code, String model, String range)
    {
        createSuccess = airBean.newAir(aircraft_code,model,Integer.parseInt(range));
    }

    public List<AircraftEntity> getAll ()
    {
        return airBean.getAll();
    }

    public void updateAircrafts(AircraftEntity aircraftEntity)
    {
        airBean.updateAircraft(aircraftEntity);
    }

    public void removeAircraft(AircraftEntity aircraftEntity){
        airBean.removeAircraft(aircraftEntity);
    }
}
