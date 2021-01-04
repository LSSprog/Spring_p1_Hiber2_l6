package orders.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_tbl")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    /*@Column(name = "buyer_id")
    private Long buyer_id;*/
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    /*@Column(name = "product_id")
    private Long product_id;*/
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price_fld")
    private int price;

    public Order(Buyer buyer, Product product,int price) {
        this.buyer = buyer;
        this.product = product;
        this.price = price;
    }

    /*public Order(Long buyer_id, Long product_id) {
        this.buyer_id = buyer_id;
        this.product_id = product_id;
    }*/
}
