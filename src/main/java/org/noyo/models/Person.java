package org.noyo.models;

import org.hibernate.envers.Audited;
import org.springframework.data.history.RevisionMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Audited
@Table(name = "person")
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    @NotNull
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "lastName")
    @NotNull
    private String lastName;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "age")
    @NotNull
    private int age;

    @Transient
    private RevisionMetadata<Integer> editVersion;

    public Person() {
    }

    public Person(String firstName, String middleName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RevisionMetadata<Integer> getEditVersion() {
        return editVersion;
    }

    public void setEditVersion(RevisionMetadata<Integer> editVersion) {
        this.editVersion = editVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person p = (Person) o;
        return Objects.equals(this.id, p.id) && Objects.equals(this.email, p.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.email);
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.middleName + " " + this.lastName + " " + this.email + " " + this.age;
    }
}
