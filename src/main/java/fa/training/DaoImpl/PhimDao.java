package fa.training.DaoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.Phim;
import fa.training.utils.HibernateUtils;

public class PhimDao {
	public static boolean insertIntoDB(Phim object) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Serializable series =  session.save(object);
			ts.commit();
			return (series != null);
		}
	}
	
	public static Phim getById(String maPhim) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<Phim> query = session.createQuery("from Phim s where s.maPhim = :maPhim",Phim.class);
			query.setParameter("maPhim", maPhim);
			List<Phim> list = query.getResultList();
			ts.commit();
			return list.get(0);
		}
	}
	
	public static List<Phim> getAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<Phim> query = session.createQuery("from Phim" ,Phim.class);
			List<Phim> list = query.getResultList();
			ts.commit();
			return list;
		}
	}
}
