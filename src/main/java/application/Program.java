package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
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
	}

}
