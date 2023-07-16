package fa.training.DaoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.DichVu;
import fa.training.utils.HibernateUtils;

public class DichVuDao {
	public static boolean insertIntoDB(DichVu object) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Serializable series =  session.save(object);
			ts.commit();
			return (series != null);
		}
	}
	
	public static DichVu getById(String maDichVu) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<DichVu> query = session.createQuery("from DichVu s where s.maDichVu = :maDichVu",DichVu.class);
			query.setParameter("maDichVu", maDichVu);
			List<DichVu> list = query.getResultList();
			ts.commit();
			return list.get(0);
		}
	}
	
	public static List<DichVu> getAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query<DichVu> query = session.createQuery("from DichVu" ,DichVu.class);
			List<DichVu> list = query.getResultList();
			ts.commit();
			return list;
		}
	}
	
	
}
