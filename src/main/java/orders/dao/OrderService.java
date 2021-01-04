package orders.dao;

import lombok.RequiredArgsConstructor;
import orders.factory.Factory;
import orders.model.Buyer;
import orders.model.Order;
import orders.model.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService { // task 3
    private final Factory factory;

    public List<Product> findAllProductsByBuyerId (Long buyer_id) {
        try (Session session = factory.getSession()){
            session.beginTransaction();
            List<Product> products = session.createQuery(String.format("SELECT o FROM Order o WHERE o.buyer_id = %d", buyer_id)).getResultList();
            //Buyer b = session.get(Buyer.class, buyer_id);
            //List<Product> products = session.createQuery(String.format("SELECT o from Order o WHERE o.buyer = %d", b)).getResultList();
            return products;
        }
    }

    public List<Buyer> findAllBuyersByProductId (Long product_id) {
        try (Session session = factory.getSession()){
            session.beginTransaction();
            List<Buyer> buyers = session.createQuery(String.format("SELECT o FROM Order WHERE o.product_id = %d", product_id)).getResultList();
            return buyers;
        }
    }

    public void saveOrUpdateOrder (Buyer buyer, Product product) { //task 4
        try (Session session = factory.getSession()){
            session.beginTransaction();
            //int price = product.getPrice();
            //session.createQuery(String.format("SELECT p.price FROM Product WHERE p.id = %d", product.getId())).getFirstResult();
            //Order newOrder = new Order(buyer.getId(), product.getId(), product.getPrice());
            Order newOrder = new Order(buyer, product, product.getPrice());
            session.saveOrUpdate(newOrder);
            session.getTransaction().commit();
        }
    }
}
