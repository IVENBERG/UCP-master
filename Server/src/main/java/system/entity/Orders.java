package system.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private String status;

    @Column(name = "time")
    private String time;

    @Column(name = "time2")
    private String time2;

    @ManyToOne(optional=false)
    @JoinColumn(name="id_user")
    private User user;

    @ManyToOne(optional=false)
    @JoinColumn(name="id_way")
    private WayInfo way;

    public int getIdOrder() {
        return idOrder;
    }
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public WayInfo getWay() {
        return way;
    }
    public void setWay(WayInfo way) {
        this.way = way;
    }
    public String getTime2() {
        return time2;
    }
    public void setTime2(String time2) {
        this.time2 = time2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return idOrder == orders.idOrder &&
                Double.compare(orders.price, price) == 0 &&
                Objects.equals(status, orders.status) &&
                Objects.equals(time, orders.time) &&
                Objects.equals(time2, orders.time2) &&
                Objects.equals(user, orders.user) &&
                Objects.equals(way, orders.way);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, price, status, time, time2, user, way);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idOrder=" + idOrder +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", time2='" + time2 + '\'' +
                ", user=" + user +
                ", way=" + way +
                '}';
    }
}
