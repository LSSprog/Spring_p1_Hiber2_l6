package orders.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "buyer_tbl")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buyer_id")
    private Long id;

    @Column(name = "name_fld")
    private String name;

    @OneToMany (mappedBy = "buyer")
    private List<Order> orders;


    public Buyer(String name) {
        this.name = name;
    }
}
