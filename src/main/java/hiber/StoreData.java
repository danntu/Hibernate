package hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {
  public static void main(String[] args) {
    StandardServiceRegistry standardServiceRegistry =
            new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

    SessionFactory factory = metadata.getSessionFactoryBuilder().build();

    Session session = factory.openSession();
    Transaction transaction = session.beginTransaction();

    Employee employee1 = new Employee();
    employee1.setId(1);
    employee1.setFirstName("Daniyar");
    employee1.setLastName("Myrzakanov");
    session.save(employee1);
    transaction.commit();
    System.out.println("successfully saved");
    factory.close();
    session.close();
  }
}
