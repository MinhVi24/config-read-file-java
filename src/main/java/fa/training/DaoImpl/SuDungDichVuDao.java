package fa.training.DaoImpl;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.SuDungDichVu;
import fa.training.utils.HibernateUtils;

public class SuDungDichVuDao {
	public static boolean insertIntoDB(SuDungDichVu object) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Serializable series =  session.save(object);
			ts.commit();
			return (series != null);
		}
	}
	
	public static void insertSuDungDichVu(int maKhachHang,String maDichVu,String maKhuyenMai,LocalDate date,LocalTime time,int soluong) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query query = session.createSQLQuery("insert into SuDungDichVu(maKhachHang,maDichVu,maKhuyenMai,ngaySuDung,gioSuDung,soLuong) values ("+maKhachHang +",'"+ maDichVu+ "','"+maKhuyenMai +"','"+date +"','"+ time+"',"+soluong+")");
			query.executeUpdate();
			ts.commit();
		}
	}
}
