package spring.model;

import java.util.Objects;

public class TransportModel {
    private int id_transport;
    private String type;
    private int speed;
    private int weight;
    private float koeff;

    public TransportModel() {
        this.id_transport = 0;
        this.type = null;
        this.speed = 0;
        this.weight = 0;
        this.koeff = 0;
    }
    public TransportModel(int id_transport, String type, int speed, int weight, float koeff) {
        this.id_transport = id_transport;
        this.type = type;
        this.speed = speed;
        this.weight = weight;
        this.koeff = koeff;
    }

    public int getId_transport() {
        return id_transport;
    }
    public void setId_transport(int id_transport) {
        this.id_transport = id_transport;
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
    public float getKoeff() {
        return koeff;
    }
    public void setKoeff(float koeff) {
        this.koeff = koeff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportModel that = (TransportModel) o;
        return id_transport == that.id_transport &&
                speed == that.speed &&
                weight == that.weight &&
                Float.compare(that.koeff, koeff) == 0 &&
                Objects.equals(type, that.type);
    }

    @Override
    public String toString() {
        return "TransportModel{" +
                "id_transport=" + id_transport +
                ", type='" + type + '\'' +
                ", speed=" + speed +
                ", weight=" + weight +
                ", koeff=" + koeff +
                '}';
    }
}
