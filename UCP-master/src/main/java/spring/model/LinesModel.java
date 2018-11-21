package spring.model;


public class LinesModel {
    private int id_line;
    private int id_transport;
    private int start_point;
    private int end_point;
    private int distance;

    public LinesModel() {
        this.id_line = 0;
        this.id_transport = 0;
        this.start_point = 0;
        this.end_point = 0;
        this.distance = 0;
    }
    public LinesModel(int id_line, int id_transport, int start_point, int end_point, int distance) {
        this.id_line = id_line;
        this.id_transport = id_transport;
        this.start_point = start_point;
        this.end_point = end_point;
        this.distance = distance;
    }

    public int getId_line() {
        return id_line;
    }
    public void setId_line(int id_line) {
        this.id_line = id_line;
    }
    public int getId_transport() {
        return id_transport;
    }
    public void setId_transport(int id_transport) {
        this.id_transport = id_transport;
    }
    public int getStart_point() {
        return start_point;
    }
    public void setStart_point(int start_point) {
        this.start_point = start_point;
    }
    public int getEnd_point() {
        return end_point;
    }
    public void setEnd_point(int end_point) {
        this.end_point = end_point;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinesModel that = (LinesModel) o;
        return id_line == that.id_line &&
                id_transport == that.id_transport &&
                start_point == that.start_point &&
                end_point == that.end_point &&
                distance == that.distance;
    }

    @Override
    public String toString() {
        return "LinesModel{" +
                "id_line=" + id_line +
                ", id_transport=" + id_transport +
                ", start_point=" + start_point +
                ", end_point=" + end_point +
                ", distance=" + distance +
                '}';
    }
}
