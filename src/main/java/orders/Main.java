package orders;

import lombok.val;
import lombok.var;
import orders.dao.BuyerDao;
import orders.factory.Factory;
import orders.model.Buyer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Factory factory = new Factory();
        factory.init();


        BuyerDao buyers = new BuyerDao(factory);
        List<Buyer> buyerList= buyers.findAllBuyers();
        System.out.println(buyerList.get(1));



    }
}
