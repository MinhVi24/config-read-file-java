package fa.training.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "TAIKHOAN")
public class TaiKhoan {
	@Id
	@Column(columnDefinition = "varchar(16)")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{2,15}$", message = "Account từ 3-16 kí tự, chỉ chứa dấu gạch dưới và không có kí tự đặc biệt")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String account;
	
	@Column(columnDefinition = "text")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[a-zA-Z\\d!@#$%^&*]{8,300}$", message = "Mật khẩu từ 8-20 kí tự, có ít nhất 1 chữ hoa, 1 số và 1 kí tự đặc biệt")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String password;
	
	@Column(columnDefinition = "varchar(20)")
	String role;
	
	@Column(columnDefinition = "varchar(20)")
	String trangThai;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@OneToOne
	@JoinColumn(name = "maKhachHang")
	KhachHang khachHang;

	public TaiKhoan() {
	}

	public TaiKhoan(String account, String password, KhachHang khachHang,String role,String trangThai) {
		this.account = account;
		this.password = password;
		this.khachHang = khachHang;
		this.role = role;
		this.trangThai = trangThai;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	@Override
	public String toString() {
		return String.format("TaiKhoan [account=%s, password=%s, khachHang=%s]", account, password, khachHang);
	}
	
	
}
