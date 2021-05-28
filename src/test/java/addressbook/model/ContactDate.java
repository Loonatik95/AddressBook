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

    public ContactDate(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = null;
        this.phone = null;
        this.email = null;
        this.group = null;
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

    @Override
    public String toString() {
        return "ContactDate{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactDate that = (ContactDate) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}
