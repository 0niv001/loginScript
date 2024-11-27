public class Admin extends User{
    private boolean admin = true;

    public Admin(String userName, String password) {
        super(userName, password);
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
