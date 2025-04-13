package Model;

// Base account object
public class Account {

    // Account member variables
    public int account_id;
    public String username;
    public String password;

    // Default Constructor
    public Account() {}

    // Copy Constructor
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Copy Constructor with  account_id
    public Account(int account_id, String username, String password) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
    }

    // account_id getter
    public int getAccount_id() {
        return account_id;
    }

    // account_id setter
    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    // username getter
    public String getUsername() {
        return username;
    }

    // username setter
    public void setUsername(String username) {
        this.username = username;
    }
 
    // password getter
    public String getPassword() {
        return password;
    }

    // password setter
    public void setPassword(String password) {
        this.password = password;
    }

    // override method for equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return account_id == account.account_id && username.equals(account.username) && password.equals(account.password);
    }
 
    // override method for toString
    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
