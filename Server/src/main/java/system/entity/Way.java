package system.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="way")
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
    private Lines line;

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
    public Lines getLine() {
        return line;
    }
    public void setLine(Lines line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Way way = (Way) o;

        if (id != way.id) return false;
        if (position != way.position) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + position;
        return result;
    }
}
