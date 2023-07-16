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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "SUATCHIEU")
public class SuatChieu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int maSuatChieu;
	
	@ManyToOne
	@JoinColumn(name = "maPhim")
	Phim phim;
	
	@ManyToOne
	@JoinColumn(name = "maPhongChieu")
	PhongChieu phongChieu;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate ngayChieu;
	
	@DateTimeFormat(pattern = "HH:mm")
	@Column(columnDefinition = "Time")
	LocalTime gioBatDau;
	
	@DateTimeFormat(pattern = "HH:mm")
	@Column(columnDefinition = "Time")
	LocalTime gioKetThuc;

	public SuatChieu() {
	}

	public SuatChieu(Phim phim, PhongChieu phongChieu, LocalDate ngayChieu, LocalTime gioBatDau,LocalTime gioKetThuc) {
		this.phim = phim;
		this.phongChieu = phongChieu;
		this.ngayChieu = ngayChieu;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
	}

	public SuatChieu(int maSuatChieu, Phim phim, PhongChieu phongChieu, LocalDate ngayChieu, LocalTime gioBatDau,
			LocalTime gioKetThuc) {
		this.maSuatChieu = maSuatChieu;
		this.phim = phim;
		this.phongChieu = phongChieu;
		this.ngayChieu = ngayChieu;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
	}

	public int getMaSuatChieu() {
		return maSuatChieu;
	}

	public void setMaSuatChieu(int maSuatChieu) {
		this.maSuatChieu = maSuatChieu;
	}

	public Phim getPhim() {
		return phim;
	}

	public void setPhim(Phim phim) {
		this.phim = phim;
	}

	public PhongChieu getPhongChieu() {
		return phongChieu;
	}

	public void setPhongChieu(PhongChieu phongChieu) {
		this.phongChieu = phongChieu;
	}

	public LocalDate getNgayChieu() {
		return ngayChieu;
	}

	public void setNgayChieu(LocalDate ngayChieu) {
		this.ngayChieu = ngayChieu;
	}

	public LocalTime getGioBatDau() {
		return gioBatDau;
	}

	public void setGioBatDau(LocalTime gioBatDau) {
		this.gioBatDau = gioBatDau;
	}

	public LocalTime getGioKetThuc() {
		return gioKetThuc;
	}

	public void setGioKetThuc(LocalTime gioKetThuc) {
		this.gioKetThuc = gioKetThuc;
	}

	
	
}
