package fa.training.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "SUDUNGDICHVU")
public class SuDungDichVu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	
	@ManyToOne
	@JoinColumn(name = "maKhachHang")
	KhachHang khachHang;
	
	@ManyToOne
	@JoinColumn(name = "maDichVu")
	DichVu dichVu;
	
	@ManyToOne
	@JoinColumn(name = "maKhuyenMai")
	KhuyenMai khuyenMai;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate ngaySuDung;
	
	@DateTimeFormat(pattern = "HH:mm")
	@Column(columnDefinition = "Time")
	LocalTime gioSuDung;
	
	@Range(min = 0, message = "Số lượng không được nhỏ hơn 0")
	int soLuong;

	public SuDungDichVu() {
	}

	public SuDungDichVu(KhachHang khachHang, DichVu dichVu, KhuyenMai khuyenMai, LocalDate ngaySuDung,
			LocalTime gioSuDung, int soLuong) {
		this.khachHang = khachHang;
		this.dichVu = dichVu;
		this.khuyenMai = khuyenMai;
		this.ngaySuDung = ngaySuDung;
		this.gioSuDung = gioSuDung;
		this.soLuong = soLuong;
	}



	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public LocalDate getNgaySuDung() {
		return ngaySuDung;
	}

	public void setNgaySuDung(LocalDate ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
	}

	public LocalTime getGioSuDung() {
		return gioSuDung;
	}

	public void setGioSuDung(LocalTime gioSuDung) {
		this.gioSuDung = gioSuDung;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return String.format(
				"SuDungDichVu [Id=%s, khachHang=%s, dichVu=%s, khuyenMai=%s, ngaySuDung=%s, gioSuDung=%s, soLuong=%s]",
				Id, khachHang, dichVu, khuyenMai, ngaySuDung, gioSuDung, soLuong);
	}

	
	
}
