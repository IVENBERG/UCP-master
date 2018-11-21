package spring.model;


public class OrderModel {
    private int id_order;
    private int id_way;
    private int id_user;
    private double price;

    public OrderModel() {
        this.id_order = 0;
        this.id_way = 0;
        this.id_user = 0;
        this.price = 0;
    }
    public OrderModel(int id_order, int id_way, int id_user, double price) {
        this.id_order = id_order;
        this.id_way = id_way;
        this.id_user = id_user;
        this.price = price;
    }

    public int getId_order() {
        return id_order;
    }
    public void setId_order(int id_order) {
        this.id_order = id_order;
    }
    public int getId_way() {
        return id_way;
    }
    public void setId_way(int id_way) {
        this.id_way = id_way;
    }
    public int getId_user() {
        return id_user;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderModel that = (OrderModel) o;
        return id_order == that.id_order &&
                id_way == that.id_way &&
                id_user == that.id_user &&
                Double.compare(that.price, price) == 0;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "id_order=" + id_order +
                ", id_way=" + id_way +
                ", id_user=" + id_user +
                ", price=" + price +
                '}';
    }
}
