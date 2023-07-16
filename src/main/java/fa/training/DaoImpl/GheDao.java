package fa.training.DaoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.Ghe;
import fa.training.utils.HibernateUtils;

public class GheDao {
	public static boolean insertIntoDB(Ghe ghe) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Serializable series =  session.save(ghe);
			ts.commit();
			return (series != null);
		}
	}
	
	public static List<Ghe> getById(String maPhongChieu) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<Ghe> query = session.createQuery("from Ghe p where p.phongChieu.maPhongChieu = :maPhongChieu",Ghe.class);
			query.setParameter("maPhongChieu", maPhongChieu);
			List<Ghe> list = query.getResultList();
			ts.commit();
			return list;
		}
	}
	
	public static List<Ghe> getAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<Ghe> query = session.createQuery("from Ghe" ,Ghe.class);
			List<Ghe> list = query.getResultList();
			ts.commit();
			return list;
		}
	}
}
