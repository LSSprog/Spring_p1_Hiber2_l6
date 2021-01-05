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

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

/*@NamedQueries({
            @NamedQuery(name = "withStudents", query = "SELECT u FROM University u JOIN FETCH u.students WHERE u.id = :id")
    })
    University universityFetch = (University)session.getNamedQuery("withStudents")
//                    .setParameter("id", 2L)
//                    .getSingleResult();
*/
}
