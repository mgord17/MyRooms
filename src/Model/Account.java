package Model;

public class Account {

    private String account_id;
    private String first_name;
    private String last_name;
    private String birth_date;
    private String email;
    private String username;
    private String password;
    private String phone;


    public Account(String account_id, String first_name, String last_name, String birth_date, String email, String username, String password, String phone) {
        this.account_id = account_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getBirthDate() {
        return this.birth_date;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return this.account_id;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setBirthDate(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id='" + account_id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Account)) return false;
        Account other = (Account)obj;
        return this.toString().equals(other.toString());

    }
}
