package orders.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_tbl")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "title_fld")
    private String title;

    @Column(name = "price_fld")
    private int price;

    @OneToMany(mappedBy ="product")
    private List<Order> orders;


    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
