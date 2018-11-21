package system.entity;

import javax.persistence.*;


@Entity
@Table(name = "service_form", schema = "project")
public class ServiceFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "message")
    private String message;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="id_users")
    private UsersEntity usersEntity;

    @ManyToOne (optional=false, cascade=CascadeType.MERGE)
    @JoinColumn (name="id_service")
    private ServiceEntity serviceEntity;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public UsersEntity getUsersEntity() {
        return usersEntity;
    }
    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }
    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }
    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceFormEntity that = (ServiceFormEntity) o;

        if (id != that.id) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "ServiceFormEntity{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
