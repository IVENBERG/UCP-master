package spring.model;

import java.util.Objects;

public class UserModel {
    private int id_user;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String role;
    private String status;

    public UserModel() {
        this.id_user = 0;
        this.login = null;
        this.password = null;
        this.name = null;
        this.surname = null;
        this.role = null;
        this.status = null;
    }
    public UserModel(int id_user, String login, String password, String name, String surname, String role, String status) {
        this.id_user = id_user;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.status = status;
    }

    public int getId_user() {
        return id_user;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return id_user == userModel.id_user &&
                Objects.equals(login, userModel.login) &&
                Objects.equals(password, userModel.password) &&
                Objects.equals(name, userModel.name) &&
                Objects.equals(surname, userModel.surname) &&
                Objects.equals(role, userModel.role) &&
                Objects.equals(status, userModel.status);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id_user=" + id_user +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
