package fa.training.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "GHE")
public class Ghe{

	@EmbeddedId
	GheId gheId;
	
	@ManyToOne
	@MapsId("MaPhongChieu")
	@JoinColumn(name = "maPhongChieu")
	PhongChieu phongChieu;
	
	@Column(columnDefinition = "varchar(3)")
	@Pattern(regexp = "^[A-Z]{1}$", message = "hàng ghế không đúng định dạng [A-Z]")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String hangGhe;

	public Ghe() {
	}

	public Ghe(PhongChieu phongChieu, String hangGhe) {
		this.phongChieu = phongChieu;
		this.hangGhe = hangGhe;
	}


	public PhongChieu getPhongChieu() {
		return phongChieu;
	}

	public void setPhongChieu(PhongChieu phongChieu) {
		this.phongChieu = phongChieu;
	}

	public String getHangGhe() {
		return hangGhe;
	}

	public void setHangGhe(String hangGhe) {
		this.hangGhe = hangGhe;
	}

	
	public GheId getGheId() {
		return gheId;
	}

	public void setGheId(GheId gheId) {
		this.gheId = gheId;
	}

	@Override
	public String toString() {
		return String.format("Ghe [maGhe=%s, phongChieu=%s, hangGhe=%s]", phongChieu, hangGhe);
	}
	
	
	
}
