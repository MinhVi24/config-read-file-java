package fa.training.finalORM;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import fa.training.DaoImpl.KhachHangDao;
import fa.training.DaoImpl.SuDungDichVuDao;
import fa.training.DaoImpl.SuatChieuDao;
import fa.training.DaoImpl.TaiKhoanDao;
import fa.training.DaoImpl.VeDao;
import fa.training.entities.DichVu;
import fa.training.entities.KhachHang;
import fa.training.entities.KhuyenMai;
import fa.training.entities.Phim;
import fa.training.entities.PhongChieu;
import fa.training.entities.SuDungDichVu;
import fa.training.entities.SuatChieu;
import fa.training.entities.TaiKhoan;
import fa.training.entities.Ve;
import fa.training.utils.FileManager;

public class ClassManager {
	private static List<KhachHang> listKH = new ArrayList<>();
	private static List<DichVu> listDV = new ArrayList<>();
	private static List<KhuyenMai> listKM = new ArrayList<>();
	private static List<Phim> listPhim = new ArrayList<>();
	private static List<PhongChieu> listPhongChieu = new ArrayList<>();
	private static List<SuatChieu> listSuatChieu = new ArrayList<>();
	private static List<TaiKhoan> listTaiKhoan = new ArrayList<>();
	private static LocalDate begin = LocalDate.of(2022, 01, 01);
	private static int recordCount = 0;
	private static PasswordEncoder pwencode;
	
	public static void main(String[] args) {
		FileManager fm = new FileManager();

		fm.readFile("data.txt", listKH, listTaiKhoan, listDV, listKM, listPhim, listPhongChieu);
		addKH();
		addData();
	}

	public static void addKH() {
		int indexKH = 51;
		String[] tenNamArray = { "Huy", "Khang", "Bảo", "Minh", "Phúc", "Anh", "Khoa", "Phát", "Đạt", "Khôi", "Long",
				"Nam", "Duy", "Quân", "Kiệt", "Thịnh", "Tuấn", "Hưng", "Hoàng", "Hiếu", "Nhân", "Trí", "Tài", "Phong",
				"Nguyên", "An", "Phú", "Thành", "Đức", "Dũng", "Lộc", "Khánh", "Vinh", "Tiến", "Nghĩa", "Thiện", "Hào",
				"Hải", "Đăng", "Quang", "Lâm", "Nhật", "Trung", "Thắng", "Tú", "Hùng", "Tâm", "Sang", "Sơn", "Thái",
				"Cường", "Vũ", "Toàn", "Ân", "Thuận", "Bình", "Trường", "Danh", "Kiên", "Phước", "Thiên", "Tân", "Việt",
				"Khải", "Tín", "Dương", "Tùng", "Quý", "Hậu", "Trọng", "Triết", "Luân", "Phương", "Quốc", "Thông",
				"Khiêm", "Hòa", "Thanh", "Tường", "Kha", "Vỹ", "Bách", "Khanh", "Mạnh", "Lợi", "Đại", "Hiệp", "Đông",
				"Nhựt", "Giang", "Kỳ", "Phi", "Tấn", "Văn", "Vương", "Công", "Hiển", "Linh", "Ngọc", "Vĩ" };
		String[] tenNuArray = { "Anh", "Vy", "Ngọc", "Nhi", "Hân", "Thư", "Linh", "Như", "Ngân", "Phương", "Thảo", "My",
				"Trân", "Quỳnh", "Nghi", "Trang", "Trâm", "An", "Thy", "Châu", "Trúc", "Uyên", "Yến", "Ý", "Tiên",
				"Mai", "Hà", "Vân", "Nguyên", "Hương", "Quyên", "Duyên", "Kim", "Trinh", "Thanh", "Tuyền", "Hằng",
				"Dương", "Chi", "Giang", "Tâm", "Lam", "Tú", "Ánh", "Hiền", "Khánh", "Minh", "Huyền", "Thùy", "Vi",
				"Ly", "Dung", "Nhung", "Phúc", "Lan", "Phụng", "Ân", "Thi", "Khanh", "Kỳ", "Nga", "Tường", "Thúy", "Mỹ",
				"Hoa", "Tuyết", "Lâm", "Thủy", "Đan", "Hạnh", "Xuân", "Oanh", "Mẫn", "Khuê", "Diệp", "Thương", "Nhiên",
				"Băng", "Hồng", "Bình", "Loan", "Thơ", "Phượng", "Mi", "Nhã", "Nguyệt", "Bích", "Đào", "Diễm", "Kiều",
				"Hiếu", "Di", "Liên", "Trà", "Tuệ", "Thắm", "Diệu", "Quân", "Nhàn", "Doanh" };
		String[] hoArray = { "Phạm", "Trần", "Hoàng", "Nguyễn", "Phan", "Hứa", "Hà", "Bùi", "Đặng", "Võ", "Vũ", "Lê",
				"Đoàn", "Huỳnh", "Vương", "Diệp", "Tăng", "Lý", "Thiềm", "Đào", "Đinh", "Lương", "Tạ", "Thái", "Lữ",
				"Chu", "Ngô", "Tống", "Châu", "Quách", "Trương", "Tô", "Hồ", "Lưu", "Hỷ", "Mai", "Dương", "Đỗ",
				"Hồng", "Phương", "Đổ", "Nông", "Cao", "Lư", "Kiên" };
		String[] tenDuongArray = { "Bà Lê Chân", "Bùi Thị Xuân", "Bùi Viện", "Cách Mạng Tháng Tám", "Calmette",
				"Cao Bá Nhạ", "Cao Bá Quát", "Cô Bắc", "Cô Giang", "Cống Quỳnh", "Chu Mạnh Trinh", "Chương Dương",
				"Đặng Dung", "Đặng Tất", "Đặng Thị Nhu", "Đặng Trần Côn", "Đề Thám", "Đinh Công Tráng", "Đông Du",
				"Đồng Khởi", "Hai Bà Trưng", "Hải Triều", "Hàm Nghi", "Hàn Thuyên", "Hòa Mỹ", "Hồ Hảo Hớn",
				"Hồ Huấn Nghiệp", "Hồ Tùng Mậu", "Hoàng Sa", "Huyền Quang", "Huyền Trân Công Chúa", "Huỳnh Khương Ninh",
				"Huỳnh Thúc Kháng", "Ký Con", "Lê Anh Xuân", "Lê Công Kiều", "Lê Duẩn", "Lê Lai", "Lê Lợi",
				"Lê Thánh Tôn", "Lê Thị Hồng Gấm", "Lê Thị Riêng", "Lê Văn Hưu", "Lương Hữu Khánh", "Lưu Văn Lang",
				"Lý Tự Trọng", "Lý Văn Phức", "Mã Lộ", "Mạc Đĩnh Chi", "Mạc Thị Bưởi", "Mai Thị Lựu",
				"Nam Kỳ Khởi Nghĩa", "Nam Quốc Cang", "Ngô Đức Kế", "Ngô Văn Năm", "Nguyễn Bỉnh Khiêm",
				"Nguyễn Cảnh Chân", "Nguyễn Công Trứ", "Nguyễn Cư Trinh", "Nguyễn Du", "Nguyễn Đình Chiểu",
				"Nguyễn Huệ", "Nguyễn Hữu Cảnh", "Nguyễn Hữu Cầu", "Nguyễn Huy Tự", "Nguyễn Khắc Nhu",
				"Nguyễn Phi Khanh", "Nguyễn Thái Bình", "Bà Huyện Thanh Quan", "Bàn Cờ", "Cao Thắng", "Điện Biên Phủ",
				"Đoàn Công Bửu", "Hồ Xuân Hương", "Huỳnh Tịnh Của", "Kỳ Đồng", "Lê Ngô Cát", "Lê Quý Đôn",
				"Nguyễn Văn Trỗi", "Lê Văn Sỹ", "Lý Chính Thắng", "Lý Thái Tổ", "Cầm Bá Thước", "Chiến Thắng",
				"Duy Tân", "Đào Duy Anh", "Đào Duy Từ", "Đặng Thai Mai", "Đặng Văn Ngữ", "Đoàn Thị Điểm",
				"Đỗ Tấn Phong", "Hải Nam", "Hoàng Diệu", "Hoàng Minh Giám", "Hoàng Văn Thụ", "Hồ Biểu Chánh",
				"Hồ Văn Huê", "Huỳnh Văn Bánh", "Lam Sơn", "Mai Văn Ngọc", "Ngô Thời Nhiệm", "Nguyễn Đình Chính",
				"Nguyễn Kiệm", "Nguyễn Thị Huỳnh", "Nguyễn Trọng Tuyển", "Nguyễn Trường Tộ", "Nguyễn Văn Đậu",
				"Nhiêu Tứ", "Phan Đăng Lưu", "Phan Đình Phùng", "Phan Tây Hồ", "Phan Xích Long", "Phổ Quang",
				"Thích Quảng Đức", "Trần Cao Vân", "Trần Huy Liệu", "Trần Hữu Trang", "Trần Kế Xương", "Trần Khắc Chân",
				"Trần Văn Đang", "Trương Quốc Dung" };
		String[] tenTinhArray = { "An Giang", "Bà Rịa – Vũng Tàu", "Bạc Liêu", "Bắc Giang", "Bắc Kạn", "Bắc Ninh",
				"Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận", "Cà Mau", "Cao Bằng", "Cần Thơ",
				"Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam",
				"Hà Nội", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Thành phố Hồ Chí Minh",
				"Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lạng Sơn", "Lào Cai", "Lâm Đồng",
				"Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình",
				"Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình",
				"Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long",
				"Vĩnh Phúc", "Yên Bái" };
		for (int i = 0; i < 10000; i++) {
			int indexTenNam = (int) (Math.floor(Math.random() * tenNamArray.length));
			int indexTenNu = (int) (Math.floor(Math.random() * tenNuArray.length));
			int indexHo = (int) (Math.floor(Math.random() * hoArray.length));
			int indexTenTinh = (int) (Math.floor(Math.random() * tenTinhArray.length));
			int indexTenDuong = (int) (Math.floor(Math.random() * tenDuongArray.length));
			int year = (int) (Math.floor(Math.random() * 40)) + 1970;
			int month = (int) (Math.floor(Math.random() * 12)) + 1;
			int day = (int) (Math.floor(Math.random() * 28)) + 1;
			LocalDate x = LocalDate.of(year, month, day);
			int emailLength = (int) (Math.floor(Math.random() * 11)) + 6;
			StringBuffer buffer = new StringBuffer();
			for (int j = 0; j < emailLength; j++) {
				int character = (int) (Math.floor(Math.random() * 26)) + 97;
				char c = (char) character;
				buffer.append(c);
			}
			String account = buffer.toString();
			buffer.append("gmail.com");
			String email = buffer.toString();
			StringBuffer sdt = new StringBuffer();
			sdt.append("09");
			for (int j = 0; j < 8; j++) {
				int nextNumber = (int) (Math.floor(Math.random() * 10));
				sdt.append(nextNumber);
			}
			int gender = (int) (Math.floor(Math.random() * 2));
			String tenKH;
			String diaChi = tenDuongArray[indexTenDuong] + ", " + tenTinhArray[indexTenTinh];
			pwencode = new BCryptPasswordEncoder(10);
			if (gender == 0) {
				tenKH = hoArray[indexHo] + " " + tenNamArray[indexTenNam];
				KhachHang kh = new KhachHang(indexKH + i, tenKH, x, email, sdt.toString(), "Nam", diaChi);
				KhachHangDao.insertIntoDB(kh);				
				TaiKhoan tk = new TaiKhoan(account, pwencode.encode(account), kh,"ROLE_USER","active");
				TaiKhoanDao.insertIntoDB(tk);
				recordCount++;
				System.out.println("Record: " + recordCount + "- KH: " + (indexKH + i));
				listKH.add(kh);
				listTaiKhoan.add(tk);
			} else {
				tenKH = hoArray[indexHo] + " " + tenNuArray[indexTenNu];
				KhachHang kh = new KhachHang(indexKH + i, tenKH, x, email, sdt.toString(), "Nữ", diaChi);
				KhachHangDao.insertIntoDB(kh);
				TaiKhoan tk = new TaiKhoan(account, pwencode.encode(account), kh,"ROLE_USER","active");
				TaiKhoanDao.insertIntoDB(tk);
				recordCount++;
				System.out.println("Record: " + recordCount + "- KH: " + (indexKH + i));
				listKH.add(kh);
				listTaiKhoan.add(tk);
			}

		}

	}

	public static void addData() {
		int indexSuatChieu = 1;
		
		LocalDate end = LocalDate.of(2023, 06, 30);
		LocalTime[] beginTime = { LocalTime.of(11, 0), LocalTime.of(13, 30), LocalTime.of(16, 00), LocalTime.of(18, 30),
				LocalTime.of(21, 0), LocalTime.of(23, 30) };
		LocalTime[] endTime = { LocalTime.of(13, 15), LocalTime.of(15, 45), LocalTime.of(18, 15), LocalTime.of(20, 45),
				LocalTime.of(23, 15), LocalTime.of(01, 15) };
		while (begin.isBefore(end)) {
			listPhongChieu.forEach(element -> {
				for (int i = 0; i < beginTime.length; i++) {
					int indexPhim = (int) (Math.floor(Math.random() * listPhim.size()));
					SuatChieu sc = new SuatChieu(indexSuatChieu, listPhim.get(indexPhim), element, begin, beginTime[i],
							endTime[i]);
					SuatChieuDao.insertIntoDB(sc);
					listSuatChieu.add(sc);
					recordCount++;
					System.out.println("Record: " + recordCount + "- SC: " + indexSuatChieu);
					addVe(element, sc, begin);
				}
			});
			int indexSDDV = 1;
			int dichVuTrongNgay = (int) (Math.floor(Math.random() * 100));
			for (int i = 0; i < dichVuTrongNgay; i++) {
				int indexMaKH = (int) (Math.floor(Math.random() * 10000) + 1);
				int indexDichVu = (int) (Math.floor(Math.random() * listDV.size()));
				int indexKhuyenMai = (int) (Math.floor(Math.random() * listKM.size()));
				int soLuong = (int) (Math.floor(Math.random() * 6));
				int hour = (int) (Math.floor(Math.random() * 24));
				int minute = (int) (Math.floor(Math.random() * 60));
				LocalTime dvTime = LocalTime.of(hour, minute);
				SuDungDichVu sddv = new SuDungDichVu(listKH.get(indexMaKH), listDV.get(indexDichVu),
						listKM.get(indexKhuyenMai), begin, dvTime, soLuong);
				SuDungDichVuDao.insertIntoDB(sddv);
				recordCount++;
				System.out.println("Record: " + recordCount + "- SDDV: " + indexSDDV);
				indexSDDV++;
			}
			begin = begin.plusDays(1);
		}

	}

	public static void addVe(PhongChieu phongChieu, SuatChieu suatChieu,LocalDate ngayMuaVe) {
		int indexVe = 1;
		int room = phongChieu.getSoLuongGhe();
		int hang = 0;
		int cot = 0;
		switch (room) {
		case 100:
			hang = 10;
			cot = 10;
			break;
		case 64:
			hang = 8;
			cot = 8;
			break;
		case 50:
			hang = 5;
			cot = 10;
		case 30:
			hang = 5;
			cot = 6;
		}
		char x = 'A';
		int random = (int) (Math.floor(Math.random() * room) + 1);
		for (int i = 0; i < hang; i++) {
			char y = (char) (x + i);
			for (int j = 0; j < cot; j++) {
				int k = j + 1;
				String maGhe = "" + y + k;
				int seed = (int) (Math.floor(Math.random() * room) + 1);
				if (seed >= random) {
				Ve ve = new Ve(suatChieu, null, null, "1", maGhe, null);
				recordCount++;
				System.out.println(
						"Record: " + recordCount + "- SC: " + suatChieu.getMaSuatChieu() + " - Ve: " + indexVe);
				indexVe++;
				VeDao.insertIntoDB(ve);
				} else {
					int indexMaKH = (int) (Math.floor(Math.random() * 10000) + 1);
					int indexKhuyenMai = (int) (Math.floor(Math.random() * listKM.size()));
					Ve ve = new Ve(suatChieu, listKH.get(indexMaKH), listKM.get(indexKhuyenMai), "2", maGhe, ngayMuaVe);
					recordCount++;
					System.out.println(
							"Record: " + recordCount + "- SC: " + suatChieu.getMaSuatChieu() + " - Ve: " + indexVe);
					indexVe++;
					VeDao.insertIntoDB(ve);
				}
			}
		}
	}
}
