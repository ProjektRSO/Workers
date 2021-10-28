package workers.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "worker")
@NamedQueries(value =
        {
                @NamedQuery(name = "worker.getAll", query = "SELECT w FROM worker w")
        })

    public class Worker {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

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
