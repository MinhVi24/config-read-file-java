package fa.training.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import fa.training.DaoImpl.DichVuDao;
import fa.training.DaoImpl.GheDao;
import fa.training.DaoImpl.KhachHangDao;
import fa.training.DaoImpl.KhuyenMaiDao;
import fa.training.DaoImpl.PhimDao;
import fa.training.DaoImpl.PhongChieuDao;
import fa.training.DaoImpl.SuDungDichVuDao;
import fa.training.DaoImpl.SuatChieuDao;
import fa.training.DaoImpl.TaiKhoanDao;
import fa.training.DaoImpl.VeDao;
import fa.training.entities.DichVu;
import fa.training.entities.Ghe;
import fa.training.entities.GheId;
import fa.training.entities.KhachHang;
import fa.training.entities.KhuyenMai;
import fa.training.entities.Phim;
import fa.training.entities.PhongChieu;
import fa.training.entities.SuatChieu;
import fa.training.entities.TaiKhoan;


public class FileManager {
	private final String PATH = "C:\\Users\\admin\\OneDrive\\Desktop\\Mock_Project\\";
	private static PasswordEncoder pwencode;
	public FileManager() {

	}

	public void readFile(String fileName,List<KhachHang> listKH,List<TaiKhoan> listTK,List<DichVu> listDV,List<KhuyenMai> listKM,List<Phim> listPhim,List<PhongChieu> listPhongChieu) {
		BufferedReader br;
		try {
			String line;
			File file = new File(PATH + fileName);
			FileReader fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			System.out.println("Reading file " + fileName);
			int index = 1;
			pwencode = new BCryptPasswordEncoder(10);
			while ((line = br.readLine()) != null) {
				System.out.print("Line " + index + ": ");
				try {
					String[] rawInput = line.split("_");
					for (int i = 0; i < rawInput.length; i++) {
						rawInput[i] = rawInput[i].trim();
					}
					String id = rawInput[0];
					switch (id) {
					case "KH":
						KhachHang kh = new KhachHang(Integer.parseInt(rawInput[1]), rawInput[2], LocalDate.parse(rawInput[3]), rawInput[4], "0" + rawInput[5], rawInput[6]	,rawInput[7]);
						KhachHangDao.insertIntoDB(kh);
						listKH.add(kh);
						break;
					case "TK":
						KhachHang kh1 = KhachHangDao.getById(Integer.parseInt(rawInput[1]));
						TaiKhoan tk = new TaiKhoan(rawInput[2],  pwencode.encode(rawInput[3]),kh1,"user","active");
						TaiKhoanDao.insertIntoDB(tk);
						listTK.add(tk);
						break;
					case "KM":
						KhuyenMai km = new KhuyenMai(rawInput[1], rawInput[2],rawInput[6], LocalDate.parse(rawInput[3]), LocalDate.parse(rawInput[4]), Double.parseDouble(rawInput[5]));
						KhuyenMaiDao.insertIntoDB(km);
						listKM.add(km);
						break;
					case "PC":
						PhongChieu pc = new PhongChieu(rawInput[1], rawInput[5], rawInput[2], Integer.parseInt(rawInput[3]), Integer.parseInt(rawInput[4]));
						PhongChieuDao.insertIntoDB(pc);
						listPhongChieu.add(pc);
						break;
					case "PH":
						String[] time = rawInput[8].split(":");
						LocalTime toTime  = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]),Integer.parseInt(time[2]));
						Phim ph = new Phim(rawInput[1], rawInput[7], rawInput[3], rawInput[2], LocalDate.parse(rawInput[5]), LocalDate.parse(rawInput[4]), toTime, rawInput[6],rawInput[9]);
						PhimDao.insertIntoDB(ph);
						listPhim.add(ph);
						break;
					case "GH":
						PhongChieu pc1 = PhongChieuDao.getById(rawInput[2]);
						GheId gheId = new GheId();
						gheId.setMaGhe(rawInput[1]);
						gheId.setMaPhongChieu(pc1.getMaPhongChieu());
						Ghe gh = new Ghe();
						gh.setGheId(gheId);
						gh.setPhongChieu(pc1);
						gh.setHangGhe(rawInput[3]);
						GheDao.insertIntoDB(gh);
						break;
					case "DV":
						DichVu dv = new DichVu(rawInput[1], rawInput[2], rawInput[4], Integer.parseInt(rawInput[3]));
						DichVuDao.insertIntoDB(dv);
						listDV.add(dv);
						break;
					case "SDDV":
						int maKH  = Integer.parseInt(rawInput[2]);
						String maDV = rawInput[1];
						String[] timeDV = rawInput[5].split(":");
						LocalTime toTimeDV  = LocalTime.of(Integer.parseInt(timeDV[0]), Integer.parseInt(timeDV[1]));
						String  maKM = rawInput[3];
						SuDungDichVuDao.insertSuDungDichVu(maKH, maDV, maKM, LocalDate.parse(rawInput[4]), toTimeDV,Integer.parseInt(rawInput[6]));
						break;
					case "SC":
						Phim phsc = PhimDao.getById(rawInput[1]);
						PhongChieu pcsc = PhongChieuDao.getById(rawInput[2]);
						String[] timesc = rawInput[4].split(":");
						LocalTime toTimesc  = LocalTime.of(Integer.parseInt(timesc[0]), Integer.parseInt(timesc[1]));
						String[] timesckt = rawInput[5].split(":");
						LocalTime toTimesckt  = LocalTime.of(Integer.parseInt(timesckt[0]), Integer.parseInt(timesckt[1]));
						SuatChieu sc = new SuatChieu(phsc, pcsc, LocalDate.parse(rawInput[3]), toTimesc,toTimesckt);
						SuatChieuDao.insertIntoDB(sc);
						break;
					case "VE":
						VeDao.insertVe(Integer.parseInt(rawInput[1]),Integer.parseInt(rawInput[2]),rawInput[3],rawInput[4],rawInput[5],LocalDate.parse(rawInput[6]));
						break;
					}
					System.out.print("OK");
					System.out.println();
				} catch (Exception e) {
				    e.printStackTrace();
					System.err.println("Program have an unexpected error occurred !!!");
				}
				index++;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
