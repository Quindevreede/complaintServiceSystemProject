package nl.quin.complaintservicesystem.model;

import javax.persistence.*;

@Entity // Announce JPA entity
@Table(	name = "roles" )
public class Role {

    @Id // Database table key is the ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Create key value sequence
    private int id;

    @Enumerated(EnumType.STRING) // Stringify enumerated role names
    @Column(length = 20) // A role may consist of a maximum of 20 characters
    private ERole name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
