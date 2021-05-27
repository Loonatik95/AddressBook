package addressbook.model;

public class ContactDate {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String phone;
    private final String email;
    private final String group;

    public ContactDate(String firstname, String lastname, String address, String phone, String email, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

}
