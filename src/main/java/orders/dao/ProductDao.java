package orders.dao;

import lombok.RequiredArgsConstructor;
import orders.factory.Factory;
import orders.model.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDao {
    private final Factory factory;

    public List<Product> findAllProducts() {
        try (Session session = factory.getSession()){
            session.beginTransaction();
            List<Product> products = session.createQuery("FROM Product").getResultList();
            return products;
        }
    }

    public Product findProductById (Long id) {
        try (Session session = factory.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            return product;
        }
    }

    public void deleteProductById (Long id) {
        try (Session session = factory.getSession()){
            session.beginTransaction();
            session.createQuery(String.format("DELETE p FROM Product WHERE p.id = %d", id));
            session.getTransaction().commit();
        }
    }

    public void saveOrUpdateProduct (Product product) {
        try (Session session = factory.getSession()){
            session.getTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }
}
