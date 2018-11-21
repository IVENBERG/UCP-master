package system.entity;

import javax.persistence.*;


@Entity
@Table(name = "service", schema = "project")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private int price;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="id_master")
    private MasterEntity masterEntity;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="id_category")
    private CategoryOfServicesEntity categoryOfServicesEntity;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public MasterEntity getMasterEntity() {
        return masterEntity;
    }
    public void setMasterEntity(MasterEntity masterEntity) {
        this.masterEntity = masterEntity;
    }
    public CategoryOfServicesEntity getCategoryOfServicesEntity() {
        return categoryOfServicesEntity;
    }
    public void setCategoryOfServicesEntity(CategoryOfServicesEntity categoryOfServicesEntity) {
        this.categoryOfServicesEntity = categoryOfServicesEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceEntity that = (ServiceEntity) o;

        if (id != that.id) return false;
        if (price != that.price) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
    @Override
    public String toString() {
        return "ServiceEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }
}
