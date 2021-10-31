package si.fri.rso2021.workers.services.dtos;

import javax.enterprise.context.RequestScoped;
import java.util.Date;

@RequestScoped
public class WorkerDTO implements java.io.Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private Date dateOfBirth;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}