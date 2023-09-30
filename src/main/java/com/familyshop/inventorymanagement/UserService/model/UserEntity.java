package com.familyshop.inventorymanagement.UserService.model;

import javax.persistence.*;

@Table(name = "users")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToOne(fetch = FetchType.EAGER)
    private Role role;
    @Embedded
    private ContactDetails contactDetails;

    public UserEntity() {
    }

    public UserEntity(String name, Role role, ContactDetails contactDetails) {
        this.name = name;
        this.role = role;
        this.contactDetails = contactDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", contactDetails=" + contactDetails +
                '}';
    }
}
