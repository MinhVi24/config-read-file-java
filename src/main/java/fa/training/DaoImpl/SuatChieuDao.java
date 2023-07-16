package fa.training.DaoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.SuatChieu;
import fa.training.utils.HibernateUtils;

public class SuatChieuDao {
	public static boolean insertIntoDB(SuatChieu object) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Serializable series =  session.save(object);
			ts.commit();
			return (series != null);
		}
	}
	
	public static SuatChieu getById(int maSuatChieu) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<SuatChieu> query = session.createQuery("from SuatChieu s where s.maSuatChieu = :maSuatChieu",SuatChieu.class);
			query.setParameter("maSuatChieu", maSuatChieu);
			List<SuatChieu> list = query.getResultList();
			ts.commit();
			return list.get(0);
		}
	}
	
	public static List<SuatChieu> getAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<SuatChieu> query = session.createQuery("from SuatChieu" ,SuatChieu.class);
			List<SuatChieu> list = query.getResultList();
			ts.commit();
			return list;
		}
	}
}
