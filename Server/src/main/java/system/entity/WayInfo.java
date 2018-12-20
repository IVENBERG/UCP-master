package system.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "way_info")
public class WayInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional=false)
    @JoinColumn(name="start_point")
    private Points start_point;

    @ManyToOne(optional=false)
    @JoinColumn(name="end_point")
    private Points end_point;

    @OneToMany(mappedBy="wayInfo")
    private List<Way> ways;

    @OneToMany(mappedBy="way")
    private List<Orders> orders;

    @Column(name = "cost")
    private double cost;

    @Column(name = "distance")
    private double distance;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Points getStart_point() {
        return start_point;
    }
    public void setStart_point(Points start_point) {
        this.start_point = start_point;
    }
    public Points getEnd_point() {
        return end_point;
    }
    public void setEnd_point(Points end_point) {
        this.end_point = end_point;
    }
    public Collection<Way> getWays() {
        return ways;
    }
    public void setWays(List<Way> ways) {
        this.ways = ways;
    }
    public Collection<Orders> getOrders() {
        return orders;
    }
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WayInfo wayInfo = (WayInfo) o;
        return id == wayInfo.id &&
                Double.compare(wayInfo.cost, cost) == 0 &&
                Double.compare(wayInfo.distance, distance) == 0 &&
                Objects.equals(start_point, wayInfo.start_point) &&
                Objects.equals(end_point, wayInfo.end_point) &&
                Objects.equals(ways, wayInfo.ways) &&
                Objects.equals(orders, wayInfo.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start_point, end_point, ways, orders, cost, distance);
    }
}
