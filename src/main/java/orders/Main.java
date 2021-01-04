package orders;

import lombok.val;
import lombok.var;
import orders.dao.BuyerDao;
import orders.dao.OrderService;
import orders.factory.Factory;
import orders.model.Buyer;
import orders.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Factory factory = new Factory();
        factory.init();


        BuyerDao buyers = new BuyerDao(factory);
        Buyer buyer1 = buyers.findById(1L);
        System.out.println(buyer1);
        List<Buyer> buyerList= buyers.findAllBuyers();
        //buyers.findAllBuyers().size();
        buyer1.getOrders().get(1);
        System.out.println(buyerList);

        OrderService orders = new OrderService(factory);
        List<Product> products = orders.findAllProductsByBuyerId(2L);
        System.out.println(products);

        factory.shutDown();

    }
}
