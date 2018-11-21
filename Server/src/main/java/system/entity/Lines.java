package ucp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="lines")
public class Lines {
    @Id
    @Column(name = "id_line")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLine;

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

    @OneToMany(mappedBy="lines")
    private Collection<Way> ways;


    public int getIdLine() {
        return idLine;
    }
    public void setIdLine(int idLine) {
        this.idLine = idLine;
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
        return idLine == lines.idLine &&
                distance == lines.distance &&
                Objects.equals(transport, lines.transport) &&
                Objects.equals(startPoint, lines.startPoint) &&
                Objects.equals(endPoint, lines.endPoint) &&
                Objects.equals(ways, lines.ways);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLine, distance, transport, startPoint, endPoint, ways);
    }
}
