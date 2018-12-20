package system.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="points")
public class Points {
    @Id
    @Column(name = "id_point")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPoint;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="startPoint")
    private Collection<Lines> startLines;

    @OneToMany(mappedBy="endPoint")
    private Collection<Lines> endLines;

    @OneToMany(mappedBy="start_point")
    private Collection<WayInfo> startWayInfo;

    @OneToMany(mappedBy="end_point")
    private Collection<WayInfo> endWayInfo;


    public int getIdPoint() {
        return idPoint;
    }
    public void setIdPoint(int idPoint) {
        this.idPoint = idPoint;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Collection<Lines> getStartLines() {
        return startLines;
    }
    public void setStartLines(Collection<Lines> startLines) {
        this.startLines = startLines;
    }
    public Collection<Lines> getEndLines() {
        return endLines;
    }
    public void setEndLines(Collection<Lines> endLines) {
        this.endLines = endLines;
    }
    public Collection<WayInfo> getStartWayInfo() {
        return startWayInfo;
    }
    public void setStartWayInfo(Collection<WayInfo> startWayInfo) {
        this.startWayInfo = startWayInfo;
    }
    public Collection<WayInfo> getEndWayInfo() {
        return endWayInfo;
    }
    public void setEndWayInfo(Collection<WayInfo> endWayInfo) {
        this.endWayInfo = endWayInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points = (Points) o;
        return idPoint == points.idPoint &&
                Objects.equals(name, points.name) &&
                Objects.equals(startLines, points.startLines) &&
                Objects.equals(endLines, points.endLines) &&
                Objects.equals(startWayInfo, points.startWayInfo) &&
                Objects.equals(endWayInfo, points.endWayInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPoint, name, startLines, endLines, startWayInfo, endWayInfo);
    }

    @Override
    public String toString() {
        return "Points{" +
                "idPoint=" + idPoint +
                ", name='" + name + '\'' +
                ", startLines=" + startLines +
                ", endLines=" + endLines +
                ", startWayInfo=" + startWayInfo +
                ", endWayInfo=" + endWayInfo +
                '}';
    }
}
