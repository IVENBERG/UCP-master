package system.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "way")
public class Way {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "position")
    private int position;

    @ManyToOne(optional=false)
    @JoinColumn(name="id_way")
    private WayInfo wayInfo;

    @ManyToOne(optional=false)
    @JoinColumn(name="id_line")
    private Lines lines;

    @OneToMany(mappedBy="way")
    private Collection<Order> orders;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public WayInfo getWayInfo() {
        return wayInfo;
    }
    public void setWayInfo(WayInfo wayInfo) {
        this.wayInfo = wayInfo;
    }
    public Lines getLines() {
        return lines;
    }
    public void setLines(Lines lines) {
        this.lines = lines;
    }
    public Collection<Order> getOrders() {
        return orders;
    }
    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Way way = (Way) o;
        return id == way.id &&
                position == way.position &&
                Objects.equals(wayInfo, way.wayInfo) &&
                Objects.equals(lines, way.lines) &&
                Objects.equals(orders, way.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, wayInfo, lines, orders);
    }
}
