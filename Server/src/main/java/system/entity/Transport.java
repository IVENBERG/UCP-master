package ucp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="transport")
public class Transport {
    @Id
    @Column(name = "id_transport")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransport;

    @Column(name = "type")
    private String type;

    @Column(name = "speed")
    private int speed;

    @Column(name = "weight")
    private int weight;

    @Column(name = "koeff")
    private double koeff;

    @OneToMany(mappedBy="transport")
    private Collection<Lines> lines;


    public int getIdTransport() {
        return idTransport;
    }
    public void setIdTransport(int idTransport) {
        this.idTransport = idTransport;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public double getKoeff() {
        return koeff;
    }
    public void setKoeff(double koeff) {
        this.koeff = koeff;
    }
    public Collection<Lines> getLines() {
        return lines;
    }
    public void setLines(Collection<Lines> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return idTransport == transport.idTransport &&
                speed == transport.speed &&
                weight == transport.weight &&
                Double.compare(transport.koeff, koeff) == 0 &&
                Objects.equals(type, transport.type) &&
                Objects.equals(lines, transport.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransport, type, speed, weight, koeff, lines);
    }
}
