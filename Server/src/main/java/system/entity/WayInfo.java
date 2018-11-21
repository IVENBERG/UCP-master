package ucp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "way_info")
public class WayInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional=false)
    @JoinColumn(name="start")
    private Points start;

    @ManyToOne(optional=false)
    @JoinColumn(name="end")
    private Points end;

    @OneToMany(mappedBy="wayInfo")
    private Collection<Way> ways;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Points getStart() {
        return start;
    }
    public void setStart(Points start) {
        this.start = start;
    }
    public Points getEnd() {
        return end;
    }
    public void setEnd(Points end) {
        this.end = end;
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
        WayInfo wayInfo = (WayInfo) o;
        return id == wayInfo.id &&
                Objects.equals(start, wayInfo.start) &&
                Objects.equals(end, wayInfo.end) &&
                Objects.equals(ways, wayInfo.ways);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, end, ways);
    }
}
