package fa.training.DaoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.KhuyenMai;
import fa.training.utils.HibernateUtils;

public class KhuyenMaiDao {
	public static boolean insertIntoDB(KhuyenMai object) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Serializable series =  session.save(object);
			ts.commit();
			return (series != null);
		}
	}
	
	public static KhuyenMai getById(String maKhuyenMai) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<KhuyenMai> query = session.createQuery("from KhuyenMai s where s.maKhuyenMai = :maKhuyenMai",KhuyenMai.class);
			query.setParameter("maKhuyenMai", maKhuyenMai);
			List<KhuyenMai> list = query.getResultList();
			ts.commit();
			return list.get(0);
		}
	}
	
	public static List<KhuyenMai> getAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<KhuyenMai> query = session.createQuery("from KhuyenMai" ,KhuyenMai.class);
			List<KhuyenMai> list = query.getResultList();
			ts.commit();
			return list;
		}
	}
}
