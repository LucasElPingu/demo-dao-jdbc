package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;

public class Program {

	public static void main(String[] args) {

		SellerDao sd = DaoFactory.createSellerDao();
		/*
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
		 */
		/*
		DepartmentDao dp = DaoFactory.createDepartmentDao();
		Department d = new Department();
		System.out.println("==================================================findById=======================================================");
		d = dp.findById(6);
		System.out.println(d!=null ? d : "Não encontrado");
		System.out.println("=================================================================================================================");
		System.out.println("\n==================================================findAll=======================================================");
		List<Department> dList = dp.findAll();
		dList.forEach(System.out::println);
		System.out.println("==================================================================================================================");
		System.out.println("\n==================================================Insert========================================================");
		d = new Department(null, "ZECA");
		dp.insert(d);
		System.out.println("Department: " + d.getId() + " Created!!!");
		System.out.println("==================================================================================================================");
		System.out.println("\n==================================================Update========================================================");
		d = new Department(6, "ZECA_CU_DE_APITO");
		dp.update(d);
		System.out.println("Update Completed!!!");
		System.out.println("==================================================================================================================");
		System.out.println("\n==================================================Delete========================================================");
		dp.deleteById(6);
		System.out.println("Department Deleted!!!");
		System.out.println("==================================================================================================================");
		 */
	}
}
