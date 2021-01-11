package orders.dao;

import lombok.RequiredArgsConstructor;
import orders.factory.Factory;
import orders.model.Buyer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyerDao {
    private final Factory factory;

    public List<Buyer> findAllBuyers() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Buyer> buyers = session.createQuery("FROM Buyer").getResultList();
            buyers.size(); // проба
            return buyers;
        }
    }

    public Buyer findById(Long id) {
        try (Session session = factory.getSession()){
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            buyer.getOrders().size();
            session.getTransaction().commit();
            return buyer;
        }
    }

    public void deleteById(Long id) {
        try (Session session = factory.getSession()){
            session.beginTransaction();
            session.createQuery(String.format("DELETE b FROM Buyer WHERE b.id = %d", id));
            session.getTransaction().commit();
        }
    }

    public void saveOrUpdate (Buyer buyer) {
        try (Session session = factory.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();
        }
    }
}
