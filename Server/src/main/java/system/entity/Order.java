package ucp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="order")
public class Order {
    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;

    @Column(name = "price")
    private double price;

    @ManyToOne(optional=false)
    @JoinColumn(name="id_user")
    private User user;

    @ManyToOne(optional=false)
    @JoinColumn(name="id_way")
    private Way way;


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
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Way getWay() {
        return way;
    }
    public void setWay(Way way) {
        this.way = way;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return idOrder == order.idOrder &&
                Double.compare(order.price, price) == 0 &&
                Objects.equals(user, order.user) &&
                Objects.equals(way, order.way);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, price, user, way);
    }
}
