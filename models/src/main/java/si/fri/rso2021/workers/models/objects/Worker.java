package si.fri.rso2021.workers.models.objects;

import java.util.Date;

public class Worker {
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private float hourlyRate;

    // if working day: write working hours, example: monday = 8.00-16.00
    // if not working: write empty string
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
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
