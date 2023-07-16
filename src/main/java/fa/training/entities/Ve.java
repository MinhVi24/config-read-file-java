package fa.training.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "VE")
public class Ve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	
	@ManyToOne
	@JoinColumn(name = "maSuatChieu")
	SuatChieu suatChieu;
	
	@ManyToOne
	@JoinColumn(name = "maKhachHang")
	KhachHang khachHang;
	
	@ManyToOne
	@JoinColumn(name = "maKhuyenMai")
	KhuyenMai khuyenMai;
	
	@Column(columnDefinition = "Nvarchar(50)")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String trangThai;
	
	@Column(columnDefinition = "varchar(7)")
	@Pattern(regexp = "^[A-Z]{1}[0-9]{1-2}$", message = "mã ghế không đúng định dạng [A-Z]xx")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String maGhe;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate ngayMuaVe;

	public Ve() {
	}

	public Ve(SuatChieu suatChieu, KhachHang khachHang, KhuyenMai khuyenMai, String trangThai,String maGhe,LocalDate ngayMuaVe) {
		this.suatChieu = suatChieu;
		this.khachHang = khachHang;
		this.khuyenMai = khuyenMai;
		this.trangThai = trangThai;
		this.maGhe = maGhe;
		this.ngayMuaVe = ngayMuaVe;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public SuatChieu getSuatChieu() {
		return suatChieu;
	}

	public void setSuatChieu(SuatChieu suatChieu) {
		this.suatChieu = suatChieu;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getMaGhe() {
		return maGhe;
	}

	public void setMaGhe(String maGhe) {
		this.maGhe = maGhe;
	}

	public LocalDate getNgayMuaVe() {
		return ngayMuaVe;
	}

	public void setNgayMuaVe(LocalDate ngayMuaVe) {
		this.ngayMuaVe = ngayMuaVe;
	}

	@Override
	public String toString() {
		return String.format("Ve [Id=%s, suatChieu=%s, khachHang=%s, khuyenMai=%s, trangThai=%s, maGhe=%s]", Id,
				suatChieu, khachHang, khuyenMai, trangThai, maGhe);
	}



	
	
}
