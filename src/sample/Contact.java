package sample;

import javafx.beans.property.SimpleStringProperty;

public class Contact {

    private SimpleStringProperty firstName;
    private SimpleStringProperty  lastName;
    private SimpleStringProperty phone;
    private SimpleStringProperty email;
    private SimpleStringProperty dob;
    private SimpleStringProperty group;

    public Contact(String firstName, String lastName, String phone, String email, String dob, String group) {

        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.dob = new SimpleStringProperty(dob);
        this.group = new SimpleStringProperty(group);

    }
    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public String getDob() {
        return dob.get();
    }

    public SimpleStringProperty dobProperty() {
        return dob;
    }

    public String getGroup() {
        return group.get();
    }

    public SimpleStringProperty groupProperty() {
        return group;
    }





    @Override
    public String toString() {

        return String.format("%-15s:%-15s:%-10s:%-25s:%-10s:%-10s",firstName,lastName,phone,email,dob,group);
    }

}

