package fa.training.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "KHUYENMAI")
public class KhuyenMai {
	@Id
	@Column(columnDefinition = "varchar(7)")
	@Pattern(regexp = "^KM[0-9]{5}$", message = "mã khuyến mãi không đúng định dạng KMxxxxx")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String maKhuyenMai;
	
	@Column(columnDefinition = "Nvarchar(50)")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String tenKhuyenMai;
	
	@Column(columnDefinition = "Ntext")
	String moTaKhuyenMai;
		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate ngayBatDau;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate ngayKetThuc;
	
	@Min(value = 0, message = "vui lòng nhập số lớn hơn hoặc bằng 0")
	double tiLeKhuyenMai;
	
	@OneToMany(mappedBy = "khuyenMai",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Set<SuDungDichVu> suDungDichVu;

	@OneToMany(mappedBy = "khuyenMai",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Set<Ve> ve;
	
	public KhuyenMai() {
		
	}

	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, String moTaKhuyenMai, LocalDate ngayBatDau, LocalDate ngayKetThuc,
			double tiLeKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.moTaKhuyenMai = moTaKhuyenMai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.tiLeKhuyenMai = tiLeKhuyenMai;
	}


	public KhuyenMai(String maKhuyenMai, String tenKhuyenMai, String moTaKhuyenMai, LocalDate ngayBatDau, LocalDate ngayKetThuc,
			double tiLeKhuyenMai, Set<SuDungDichVu> suDungDichVu, Set<Ve> ve) {
		this.maKhuyenMai = maKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.moTaKhuyenMai = moTaKhuyenMai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.tiLeKhuyenMai = tiLeKhuyenMai;
		this.suDungDichVu = suDungDichVu;
		this.ve = ve;
	}

	public String getMaKhuyenMai() {
		return maKhuyenMai;
	}

	public void setMaKhuyenMai(String maKhuyenMai) {
		this.maKhuyenMai = maKhuyenMai;
	}

	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}

	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}

	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public LocalDate getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(LocalDate ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public double getTiLeKhuyenMai() {
		return tiLeKhuyenMai;
	}

	public void setTiLeKhuyenMai(double tiLeKhuyenMai) {
		this.tiLeKhuyenMai = tiLeKhuyenMai;
	}

	public Set<SuDungDichVu> getSuDungDichVu() {
		return suDungDichVu;
	}

	public void setSuDungDichVu(Set<SuDungDichVu> suDungDichVu) {
		this.suDungDichVu = suDungDichVu;
	}

	public Set<Ve> getVe() {
		return ve;
	}

	public void setVe(Set<Ve> ve) {
		this.ve = ve;
	}

	public String getMoTaKhuyenMai() {
		return moTaKhuyenMai;
	}

	public void setMoTaKhuyenMai(String moTaKhuyenMai) {
		this.moTaKhuyenMai = moTaKhuyenMai;
	}

	@Override
	public String toString() {
		return String.format(
				"KhuyenMai [maKhuyenMai=%s, tenKhuyenMai=%s, moTaKhuyenMai=%s, ngayBatDau=%s, ngayKetThuc=%s, tiLeKhuyenMai=%s, suDungDichVu=%s, ve=%s]",
				maKhuyenMai, tenKhuyenMai, moTaKhuyenMai, ngayBatDau, ngayKetThuc, tiLeKhuyenMai, suDungDichVu, ve);
	}

	
}
