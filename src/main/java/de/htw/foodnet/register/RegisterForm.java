package de.htw.foodnet.register;

public class RegisterForm {
    private String username;
    private String password;
    private boolean chef;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isChef() {
        return chef;
    }

    public void setChef(boolean chef) {
        this.chef = chef;
    }
}
