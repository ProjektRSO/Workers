package si.fri.rso2021.workers.services.dtos;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class WorkerDTO implements java.io.Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private float hourlyRate;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }
    public String getMonday() {
        return monday;
    }
    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getFriday() {
        return friday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getSunday() {
        return sunday;
    }
}
