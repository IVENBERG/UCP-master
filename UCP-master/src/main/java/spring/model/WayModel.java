package spring.model;


public class WayModel {
    private int id;
    private int id_way;
    private int id_line;
    private int position;

    public WayModel() {
        this.id = 0;
        this.id_way = 0;
        this.id_line = 0;
        this.position = 0;
    }
    public WayModel(int id, int id_way, int id_line, int position) {
        this.id = id;
        this.id_way = id_way;
        this.id_line = id_line;
        this.position = position;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_way() {
        return id_way;
    }
    public void setId_way(int id_way) {
        this.id_way = id_way;
    }
    public int getId_line() {
        return id_line;
    }
    public void setId_line(int id_line) {
        this.id_line = id_line;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WayModel wayModel = (WayModel) o;
        return id == wayModel.id &&
                id_way == wayModel.id_way &&
                id_line == wayModel.id_line &&
                position == wayModel.position;
    }

    @Override
    public String toString() {
        return "WayModel{" +
                "id=" + id +
                ", id_way=" + id_way +
                ", id_line=" + id_line +
                ", position=" + position +
                '}';
    }
}
