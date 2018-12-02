package system.entity;

import javax.persistence.*;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (idOrder != orders.idOrder) return false;
        if (Double.compare(orders.price, price) != 0) return false;
        if (status != null ? !status.equals(orders.status) : orders.status != null) return false;
        if (time != null ? !time.equals(orders.time) : orders.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idOrder;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idOrder=" + idOrder +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", user=" + user +
                ", way=" + way +
                '}';
    }
}
