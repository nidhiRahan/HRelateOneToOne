package onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OurLogic {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		
        Student s=new Student();
		s.setStudentId(100);
		s.setStudentName("natara");
        Address ad = new Address();
		ad.setAddressId(600);
		ad.setCity("calli");
		ad.setState("C");
		ad.setS(s);
	    Transaction tx = session.beginTransaction();
        session.save(ad);
        tx.commit();
        session.close();
		System.out.println("One to One is Done..!!");
		factory.close();

	}
}