package si.fri.rso2021.workers.models.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "workers")
@NamedQueries(value =
        {
                @NamedQuery(name = "WorkerEntity.getAll", query = "SELECT w FROM WorkerEntity w")
        })

public class WorkerEntity implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    // getter and setter methods


    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

