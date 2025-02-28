package application;

import java.time.LocalDate;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department d = new Department(1, "books");
		Seller s = new Seller(12, "zeca", "zeca@gmail.com", LocalDate.now(), 13.000, d);
		System.out.println(s);

	}

}
