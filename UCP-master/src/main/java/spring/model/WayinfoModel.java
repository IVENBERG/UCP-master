package spring.model;


public class WayinfoModel {
    private int id;
    private int start;
    private int end;

    public WayinfoModel() {
        this.id = 0;
        this.start = 0;
        this.end = 0;
    }
    public WayinfoModel(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WayinfoModel that = (WayinfoModel) o;
        return id == that.id &&
                start == that.start &&
                end == that.end;
    }

    @Override
    public String toString() {
        return "WayinfoModel{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
