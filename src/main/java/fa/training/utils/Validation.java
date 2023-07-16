package fa.training.utils;

import java.util.Scanner;

public class Validation {
	private static Scanner input = new Scanner(System.in);

	/**
	 * ViTM - 2004
	 * @param message
	 * @return
	 * kiểm tra 1 biến Float nhập vào
	 */
	public float checkFloat(String message) {
		do {
			float x = 0;
			System.out.print(message);
			try {
				x = Float.parseFloat(input.nextLine());
				if (x > 0)
					return x;
				System.out.println("Input must greater than 0");
			} catch (Exception e) {
				System.out.println("Must input a number");
			}
		} while (true);
	}

	/**
	 * ViTM - 2004
	 * @param message
	 * @return
	 * kiểm tra 1 biến double nhập vào
	 */
	public double checkDouble(String message) {
		do {
			double x = 0;
			System.out.print(message);
			try {
				x = Double.parseDouble(input.nextLine());
				if (x > 0)
					return x;
				System.out.println("Input must greater than 0");
			} catch (Exception e) {
				System.out.println("Must input a number");
			}
		} while (true);
	}
	
	public int checkInt(String message) {
		do {
			int x = 0;
			System.out.print(message);
			try {
				x = Integer.parseInt(input.nextLine());
				if (x > 0)
					return x;
				System.out.println("Input must greater than 0");
			} catch (Exception e) {
				System.out.println("Must input a number");
			}
		} while (true);
	}
}
