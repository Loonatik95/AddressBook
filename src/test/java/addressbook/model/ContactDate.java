package addressbook.model;

public class ContactDate {

    private String firstname;
    private String lastname;
    private String address;
    private String phone;
    private String email;
    private String group;
    private String mobile;
    private String work;
    private int id;
    private String email2;
    private String email3;
    private String allEmails;
    private String allPhones;


    public ContactDate withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactDate withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactDate withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactDate withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ContactDate withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactDate withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactDate withId(int id) {
        this.id = id;
        return this;
    }

    public ContactDate withMobilePhone(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactDate withWorkPhone(String work) {
        this.work = work;
        return this;
    }

    public ContactDate withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactDate withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactDate withAllEmails(String emails) {
        this.allEmails = emails;
        return this;
    }

    public ContactDate withAllPhones(String phones) {
        this.allPhones = phones;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
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

    public int getId() {
        return id;
    }

    public String getFullName() {
        return firstname + " " + lastname;
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
