package fa.training.DaoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.PhongChieu;
import fa.training.entities.PhongChieu;
import fa.training.utils.HibernateUtils;

public class PhongChieuDao {
	public static boolean insertIntoDB(PhongChieu object) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Serializable series =  session.save(object);
			ts.commit();
			return (series != null);
		}
	}
	
	public static PhongChieu getById(String maPhongChieu) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			System.out.println(maPhongChieu);
			Query<PhongChieu> query = session.createQuery("from PhongChieu p where p.maPhongChieu = :maPhongChieu",PhongChieu.class);
			query.setParameter("maPhongChieu", maPhongChieu);
			List<PhongChieu> list = query.getResultList();
			ts.commit();
			return list.get(0);
		}
	}
	
	public static List<PhongChieu> getAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<PhongChieu> query = session.createQuery("from PhongChieu" ,PhongChieu.class);
			List<PhongChieu> list = query.getResultList();
			ts.commit();
			return list;
		}
	}
}
