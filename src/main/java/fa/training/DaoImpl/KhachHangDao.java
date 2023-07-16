package fa.training.DaoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.KhachHang;
import fa.training.utils.HibernateUtils;

public class KhachHangDao {
	public static boolean insertIntoDB(KhachHang khachHang) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Serializable series =  session.save(khachHang);
			ts.commit();
			return (series != null);
		}
	}
	
	public static KhachHang getById(int maKhachHang) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<KhachHang> query = session.createQuery("from KhachHang s where s.maKhachHang = :maKhachHang",KhachHang.class);
			query.setParameter("maKhachHang", maKhachHang);
			List<KhachHang> list = query.getResultList();
			ts.commit();
			return list.get(0);
		}
	}
	
	public static List<KhachHang> getAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<KhachHang> query = session.createQuery("from KhachHang" ,KhachHang.class);
			List<KhachHang> list = query.getResultList();
			ts.commit();
			return list;
		}
	}
}
