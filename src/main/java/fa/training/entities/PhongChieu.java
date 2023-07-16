package fa.training.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "PHONGCHIEU")
public class PhongChieu {
	@Id
	@Column(columnDefinition = "varchar(7)")
	@Pattern(regexp = "^PC[0-9]{5}$", message = "mã phòng chiếu không đúng định dạng PCxxxxx")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String maPhongChieu;
	
	@Column(columnDefinition = "Nvarchar(20)")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String tenPhong;
	
	@Column(columnDefinition = "Nvarchar(10)")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String hangPhong;
	
	@Range(min = 0, message = "Số lượng ghế không được nhỏ hơn 0")
	int soLuongGhe;
	
	@Range(min = 0, message = "Đơn giá không được nhỏ hơn 0")
	int donGia;
	
	@OneToMany(mappedBy = "phongChieu",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Set<SuatChieu> suatChieu;
	
	@OneToMany(mappedBy = "phongChieu",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Set<Ghe> ghe;

	public PhongChieu() {
	}

	public PhongChieu(String maPhongChieu,String tenPhong, String hangPhong, int soLuongGhe,int donGia, Set<SuatChieu> suatChieu, Set<Ghe> ghe) {
		this.maPhongChieu = maPhongChieu;
		this.tenPhong = tenPhong;
		this.hangPhong = hangPhong;
		this.soLuongGhe = soLuongGhe;
		this.suatChieu = suatChieu;
		this.ghe = ghe;
		this.donGia = donGia;
	}

	public PhongChieu(String maPhongChieu,String tenPhong, String hangPhong, int soLuongGhe,int donGia) {
		this.maPhongChieu = maPhongChieu;
		this.tenPhong = tenPhong;
		this.hangPhong = hangPhong;
		this.soLuongGhe = soLuongGhe;
		this.donGia = donGia;
	}

	public String getMaPhongChieu() {
		return maPhongChieu;
	}

	public void setMaPhongChieu(String maPhongChieu) {
		this.maPhongChieu = maPhongChieu;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getHangPhong() {
		return hangPhong;
	}

	public void setHangPhong(String hangPhong) {
		this.hangPhong = hangPhong;
	}

	public int getSoLuongGhe() {
		return soLuongGhe;
	}

	public void setSoLuongGhe(int soLuongGhe) {
		this.soLuongGhe = soLuongGhe;
	}

	public Set<SuatChieu> getSuatChieu() {
		return suatChieu;
	}

	public void setSuatChieu(Set<SuatChieu> suatChieu) {
		this.suatChieu = suatChieu;
	}

	public Set<Ghe> getGhe() {
		return ghe;
	}

	public void setGhe(Set<Ghe> ghe) {
		this.ghe = ghe;
	}
	
	

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		return String.format(
				"PhongChieu [maPhongChieu=%s, hangPhong=%s, soLuongGhe=%s, donGia=%s, suatChieu=%s, ghe=%s]",
				maPhongChieu, hangPhong, soLuongGhe, donGia, suatChieu, ghe);
	}
	
	
}
