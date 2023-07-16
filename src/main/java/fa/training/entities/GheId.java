package fa.training.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Embeddable
public class GheId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "MaGhe",columnDefinition = "varchar(7)")
	@Pattern(regexp = "^[A-Z]{1}[0-9]{1-2}$", message = "mã ghế không đúng định dạng [A-Z]xx")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String maGhe;
	
	@Column(name = "MaPhongChieu", columnDefinition = "varchar(7)")
	@Pattern(regexp = "^PC[0-9]{5}$", message = "mã phòng chiếu không đúng định dạng PCxxxxx")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String maPhongChieu;

	@Override
	public int hashCode() {
		return Objects.hash(maGhe, maPhongChieu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GheId other = (GheId) obj;
		return Objects.equals(maGhe, other.maGhe) && Objects.equals(maPhongChieu, other.maPhongChieu);
	}

	public String getMaGhe() {
		return maGhe;
	}

	public void setMaGhe(String maGhe) {
		this.maGhe = maGhe;
	}

	public String getMaPhongChieu() {
		return maPhongChieu;
	}

	public void setMaPhongChieu(String maPhongChieu) {
		this.maPhongChieu = maPhongChieu;
	}
	
	
}
