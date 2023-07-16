package fa.training.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="KHACHHANG")
public class KhachHang {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int maKhachHang;
	
	@Column(columnDefinition = "Nvarchar(50)")
	@Pattern(regexp = "^[a-zA-ZÀ-ỹỲ-ỹĐđ]+(\\s[a-zA-ZÀ-ỹỲ-ỹĐđ]+)+{3-50}$", message = "Họ tên ít nhất phải có 2 từ và dài từ 3-50 kí tự")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String tenKhachHang;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "Ngày sinh phải nhỏ hơn ngày hiện tại")
	LocalDate ngaySinh;
	
	@Column(columnDefinition = "varchar(50)")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Địa chỉ email không đúng định dạng")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String email;
	
	@Column(columnDefinition = "varchar(11)")
	@Pattern(regexp = "0[0-9]{9}", message = "Số điện thoại phải bắt đầu bằng 0 và có 10 số")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String sdt;
	
	@Column(columnDefinition = "Nvarchar(5)")
	String gioiTinh;
	
	@Column(columnDefinition = "Nvarchar(100)")
	String diaChi;
	
	@OneToOne(mappedBy = "khachHang",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	TaiKhoan taiKhoan;
	
	@OneToMany(mappedBy = "khachHang",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Set<SuDungDichVu> suDungDichVu;
	
	@OneToMany(mappedBy = "khachHang",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Set<Ve> ve;
	
	public KhachHang() {
		super();
	}

	
	public KhachHang(int maKhachHang, String tenKhachHang, LocalDate ngaySinh, String email, String sdt,
			String gioiTinh, String diaChi, TaiKhoan taiKhoan, Set<SuDungDichVu> suDungDichVu, Set<Ve> ve) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
		this.suDungDichVu = suDungDichVu;
		this.ve = ve;
	}


	public KhachHang(int maKhachHang, String tenKhachHang, LocalDate ngaySinh, String email, String sdt,
			String gioiTinh, String diaChi) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}
	
	

	public KhachHang(String tenKhachHang, LocalDate ngaySinh, String email, String sdt, String gioiTinh, String diaChi,
			TaiKhoan taiKhoan) {
		this.tenKhachHang = tenKhachHang;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
	}


	public int getMaKhachHang() {
		return maKhachHang;
	}


	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}


	public String getGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
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


	@Override
	public String toString() {
		return String.format(
				"KhachHang [maKhachHang=%s, tenKhachHang=%s, ngaySinh=%s, email=%s, sdt=%s, gioiTinh=%s, diaChi=%s, taiKhoan=%s, suDungDichVu=%s, ve=%s]",
				maKhachHang, tenKhachHang, ngaySinh, email, sdt, gioiTinh, diaChi, taiKhoan, suDungDichVu, ve);
	}


}
