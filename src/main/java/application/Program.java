package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sd = DaoFactory.createSellerDao();

		System.out.println("==================================================findById=======================================================");
		Seller seller = sd.findById(3);
		System.out.println(seller!=null ? seller : "Não encontrado");
		System.out.println("=================================================================================================================");
		System.out.println("\n==================================================findByDepartment===============================================");
		List<Seller> sellerList = sd.findByDepartment(new Department(2, null));
		if(!sellerList.isEmpty()) //Verifica se a lista esta vazia
			sellerList.forEach(System.out::println);
		else System.out.println("Departamente não inexistente!!!");
		System.out.println("==================================================================================================================");
		System.out.println("\n==================================================findAll=======================================================");
		List<Seller> sellerListAll = sd.findAll();
		if(!sellerList.isEmpty()) //Verifica se a lista esta vazia
			sellerListAll.forEach(System.out::println);
		else System.out.println("Nenhum valor encontrado!!!");
		System.out.println("==================================================================================================================");
		System.out.println("\n==================================================Insert========================================================");
		Seller newseller = new Seller(null, "Recruta", "pinguim@gmail.com", LocalDate.parse("1993-03-17"), 3000.00, new Department(2, null));
		sd.insert(newseller);
		System.out.println("New Employee Id: " + newseller.getId());
		System.out.println("==================================================================================================================");
		System.out.println("\n==================================================Update========================================================");
		seller = sd.findById(1);
		seller.setName("Martha Waine");
		sd.update(seller);
		System.out.println("Updated Completed");
		System.out.println("==================================================================================================================");
		System.out.println("\n==================================================Delete========================================================");
		sd.deleteById(72);
		System.out.println("Employee Deleted!!!");
		System.out.println("==================================================================================================================");
	}

}
