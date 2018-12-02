package system.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "way_lines")
public class Lines {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "distance")
    private int distance;

    @ManyToOne(optional=false)
    @JoinColumn(name="id_transport")
    private Transport transport;

    @ManyToOne(optional=false)
    @JoinColumn(name="start_point")
    private Points startPoint;

    @ManyToOne(optional=false)
    @JoinColumn(name="end_point")
    private Points endPoint;

    @OneToMany(mappedBy="line")
    private Collection<Way> ways;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public Transport getTransport() {
        return transport;
    }
    public void setTransport(Transport transport) {
        this.transport = transport;
    }
    public Points getStartPoint() {
        return startPoint;
    }
    public void setStartPoint(Points startPoint) {
        this.startPoint = startPoint;
    }
    public Points getEndPoint() {
        return endPoint;
    }
    public void setEndPoint(Points endPoint) {
        this.endPoint = endPoint;
    }
    public Collection<Way> getWays() {
        return ways;
    }
    public void setWays(Collection<Way> ways) {
        this.ways = ways;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lines lines = (Lines) o;

        if (id != lines.id) return false;
        if (distance != lines.distance) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + distance;
        return result;
    }
}
