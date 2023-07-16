package fa.training.DaoImpl;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.entities.Ve;
import fa.training.utils.HibernateUtils;

public class VeDao {
	public static boolean insertIntoDB(Ve object) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Serializable series =  session.save(object);
			ts.commit();
			return (series != null);
		}
	}
	
	public static void insertVe(int maSuatChieu,int maKhachHang,String maGhe,String maKhuyenMai,String status,LocalDate ngayMuaVe) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query query = session.createSQLQuery("insert into ve(maSuatChieu,maKhachHang,maGhe,maKhuyenMai,trangThai,ngayMuaVe) values ("+maSuatChieu +","+ maKhachHang+ " ,'"+maGhe +"','"+maKhuyenMai +"','"+ status+"','"+ngayMuaVe+"')");
			query.executeUpdate();
			ts.commit();
		}
	}
	
	public static boolean saveOrUpdate(Ve ve,int maSuatChieu) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction ts = session.beginTransaction();
			Query query = session.createSQLQuery("update ve set trangthai = '2',ngayMuaVe = '"+ ve.getNgayMuaVe() +"', maKhachHang = '"+ ve.getKhachHang().getMaKhachHang() + "', maKhuyenMai = '"+ ve.getKhuyenMai().getMaKhuyenMai()+"' where maSuatChieu = '" + maSuatChieu + "' and maGhe = '" + ve.getMaGhe() + "'" );
			int x = query.executeUpdate();
			ts.commit();
			if ( x!= 0 ) {
				return true;
			}
			return false;
		}
	}
}
