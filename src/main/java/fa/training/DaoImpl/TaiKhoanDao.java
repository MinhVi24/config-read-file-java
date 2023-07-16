package fa.training.DaoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.TaiKhoan;
import fa.training.utils.HibernateUtils;

public class TaiKhoanDao {
	public static boolean insertIntoDB(TaiKhoan object) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Serializable series =  session.save(object);
			ts.commit();
			return (series != null);
		}
	}
	
	public static TaiKhoan getById(String account) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<TaiKhoan> query = session.createQuery("from TaiKhoan s where s.account = :account",TaiKhoan.class);
			query.setParameter("account", account);
			List<TaiKhoan> list = query.getResultList();
			ts.commit();
			return list.get(0);
		}
	}
	
	public static List<TaiKhoan> getAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<TaiKhoan> query = session.createQuery("from TaiKhoan" ,TaiKhoan.class);
			List<TaiKhoan> list = query.getResultList();
			ts.commit();
			return list;
		}
	}
}
