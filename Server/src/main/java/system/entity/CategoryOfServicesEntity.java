package system.entity;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "category_of_services", schema = "project")
public class CategoryOfServicesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "hrewService")
    private String hrewService;

    @Column(name = "image")
    private String image;


    @OneToMany (mappedBy="categoryOfServicesEntity", fetch=FetchType.EAGER)
    private Collection<ServiceEntity> serviceEntity;

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
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getHrewService() {
        return hrewService;
    }
    public void setHrewService(String hrewService) {
        this.hrewService = hrewService;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryOfServicesEntity that = (CategoryOfServicesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (hrewService != null ? !hrewService.equals(that.hrewService) : that.hrewService != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (hrewService != null ? hrewService.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "CategoryOfServicesEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hrewService='" + hrewService + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
