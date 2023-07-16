package fa.training.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PHIM")
public class Phim {

	@Id
	@Column(columnDefinition = "varchar(7)")
	@Pattern(regexp = "^PH[0-9]{5}$", message = "mã phim không đúng định dạng PHxxxxx")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String maPhim;
	
	@Column(columnDefinition = "Nvarchar(50)")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String tenPhim;
	
	@Column(columnDefinition = "Ntext")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String moTaPhim;
	
	@Column(columnDefinition = "Nvarchar(50)")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String daoDien;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "Ngày khởi chiếu phải lớn hơn ngày hiện tại")
	LocalDate ngayKhoiChieu;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "Ngày kết thúc phải lớn hơn ngày hiện tại")
	LocalDate ngayKetThuc;
	
	@DateTimeFormat(pattern = "HH:mm")
	@Column(columnDefinition = "Time")
	LocalTime thoiLuong;
	
	@Column(name = "ImagePath")
	String poster;
	
	@Column(columnDefinition = "Ntext")
	String noiDungPhim;
	
	@OneToMany(mappedBy = "phim",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Set<SuatChieu> suatChieu;

	public Phim() {
	}

	public Phim(String maPhim, String tenPhim, String moTaPhim, String daoDien, LocalDate ngayKhoiChieu,
			LocalDate ngayKetThuc, LocalTime thoiLuong,String poster, Set<SuatChieu> suatChieu) {
		this.maPhim = maPhim;
		this.tenPhim = tenPhim;
		this.moTaPhim = moTaPhim;
		this.daoDien = daoDien;
		this.ngayKhoiChieu = ngayKhoiChieu;
		this.ngayKetThuc = ngayKetThuc;
		this.thoiLuong = thoiLuong;
		this.suatChieu = suatChieu;
		this.poster = poster;
	}

	public Phim(String maPhim, String tenPhim, String moTaPhim, String daoDien, LocalDate ngayKhoiChieu,
			LocalDate ngayKetThuc, LocalTime thoiLuong, String poster, String noiDungPhim) {
		this.maPhim = maPhim;
		this.tenPhim = tenPhim;
		this.moTaPhim = moTaPhim;
		this.daoDien = daoDien;
		this.ngayKhoiChieu = ngayKhoiChieu;
		this.ngayKetThuc = ngayKetThuc;
		this.thoiLuong = thoiLuong;
		this.poster = poster;
		this.noiDungPhim = noiDungPhim;
	}

	
	public String getNoiDungPhim() {
		return noiDungPhim;
	}

	public void setNoiDungPhim(String noiDungPhim) {
		this.noiDungPhim = noiDungPhim;
	}

	public String getMaPhim() {
		return maPhim;
	}

	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	public String getMoTaPhim() {
		return moTaPhim;
	}

	public void setMoTaPhim(String moTaPhim) {
		this.moTaPhim = moTaPhim;
	}

	public String getDaoDien() {
		return daoDien;
	}

	public void setDaoDien(String daoDien) {
		this.daoDien = daoDien;
	}

	public LocalDate getNgayKhoiChieu() {
		return ngayKhoiChieu;
	}

	public void setNgayKhoiChieu(LocalDate ngayKhoiChieu) {
		this.ngayKhoiChieu = ngayKhoiChieu;
	}

	public LocalDate getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public LocalTime getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(LocalTime thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public Set<SuatChieu> getSuatChieu() {
		return suatChieu;
	}

	public void setSuatChieu(Set<SuatChieu> suatChieu) {
		this.suatChieu = suatChieu;
	}
	
	

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@Override
	public String toString() {
		return String.format(
				"Phim [maPhim=%s, tenPhim=%s, moTaPhim=%s, daoDien=%s, ngayKhoiChieu=%s, ngayKetThuc=%s, thoiLuong=%s, poster=%s, suatChieu=%s]",
				maPhim, tenPhim, moTaPhim, daoDien, ngayKhoiChieu, ngayKetThuc, thoiLuong, poster, suatChieu);
	}
	
}
