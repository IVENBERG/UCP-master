package spring.model;


import java.util.Objects;

public class PointsModel {
    private int id_point;
    private String name;

    public PointsModel() {
        this.id_point = 0;
        this.name = null;
    }
    public PointsModel(int id_point, String name) {
        this.id_point = id_point;
        this.name = name;
    }

    public int getId_point() {
        return id_point;
    }
    public void setId_point(int id_point) {
        this.id_point = id_point;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointsModel that = (PointsModel) o;
        return id_point == that.id_point &&
                Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "PointsModel{" +
                "id_point=" + id_point +
                ", name='" + name + '\'' +
                '}';
    }
}
