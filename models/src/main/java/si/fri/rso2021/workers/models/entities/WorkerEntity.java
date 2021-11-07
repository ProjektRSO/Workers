package si.fri.rso2021.workers.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "workers")
@NamedQueries(value =
        {
                @NamedQuery(name = "WorkerEntity.getAll", query = "SELECT w FROM WorkerEntity w")
        })

public class WorkerEntity implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "hourlyRate")
    private float hourlyRate;

    @Column(name = "monday")
    private String monday;

    @Column(name = "tuesday")
    private String tuesday;

    @Column(name = "wednesday")
    private String wednesday;

    @Column(name = "thursday")
    private String thursday;

    @Column(name = "friday")
    private String friday;

    @Column(name = "saturday")
    private String saturday;

    @Column(name = "sunday")
    private String sunday;

    // getter and setter methods


    public String getSunday() {
        return sunday;
    }

    public String getSaturday() {
        return saturday;
    }

    public String getFriday() {
        return friday;
    }

    public String getThursday() {
        return thursday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public String getMonday() {
        return monday;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

