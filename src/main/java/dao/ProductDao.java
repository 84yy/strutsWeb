package dao;

import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDao {

    public void add(Product p){
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        session.beginTransaction();
        try {
            session.save(p);
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        factory.close();
    }

    public Product get(int id){
        Product product=new Product();
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        session.beginTransaction();
        try {
            product=(Product)session.get(Product.class,id);
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        return product;
    }
}
