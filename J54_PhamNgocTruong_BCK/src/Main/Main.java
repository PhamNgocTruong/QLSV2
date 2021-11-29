package Main;

import java.io.File;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import Task.Search;
import Task.ShowTableMark;
import Task.UpdateList;

public class Main {
	private static String s = "-----------------------------------------";
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		if (args[0].startsWith("-dir=") == false) {
			System.out.println("Bạn nhập sai định dạng đầu vào " + "(java -jar QLSV.jar -dir=C:\\data"
					+ "\nTrong đó: C:\\data là thư mục chứa file data\r\n"
					+ "các file trong thư mục này lấy từ thư mục data được cho trong file đính kèm)");
		} else {
			String partten = args[0].substring(5, args[0].length());
			System.out.println(partten);
			File fileSt = new File(partten + "//sinhvien_en.txt");
			File fileOb = new File(partten + "//monhoc_en.txt");
			File fileMk = new File(partten + "//diem.txt");
			if (fileSt.exists() == true && fileOb.exists() == true && fileMk.exists() == true) {
				int choose;
				do {
					System.out.println("\t\t\t" + s);
					System.out.println("\t\t\t|\tQUẢN LÝ SINH VIÊN V.1.0.0\t|\t\t");
					System.out.println("\t\t\t" + s);
					while (true) {
						choose = 1;
						menuPrint();
						System.out.println("Chọn:");
						try {
							String stringChoose = sc.nextLine();
							choose = Integer.parseInt(stringChoose);
							switch (choose) {
							case 1:
								UpdateList.updateList(partten);
								break;
							case 2:
								ShowTableMark.showList(partten);
								break;
							case 3:
								Search.searchInfo(partten);
								break;
							case 0:
								break;
							default:
								System.out.println("Không có lựa chọn này");
								break;
							}
						} catch (Exception e) {
							System.out.println("Nhập sai");
						} finally {
							if (choose == 0) {
								break;
							}
						}
					}

				} while (choose != 0);
			} else {
				System.out.println("File vừa nhập không tồn tại "
						+ "hoặc không có file dữ liệu\n,"
						+ " mời bạn nhập lại đường dẫn");
			}
		}
	}

	

	// xuât menu
	private static void menuPrint() {
		System.out.println("\n" + s);
		System.out.println("|\t\tMENU\t\t\t|");
		System.out.println(s);
		System.out.format("| %-2d. %-34s|", 1, "Cập Nhật Danh sách");
		System.out.format("\n| %-2d. %-34s|", 2, "Hiển thị Bảng Điểm");
		System.out.format("\n| %-2d. %-34s|", 0, "Thoát");
		System.out.println("\n" + s);
	}

}
