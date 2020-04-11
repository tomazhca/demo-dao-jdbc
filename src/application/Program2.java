package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao DepartmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department findById ===");
		Department Department = DepartmentDao.findById(3);
		System.out.println(Department);
		
		System.out.println("\n=== TEST 2: Department findAll ===");
		List<Department> list = DepartmentDao.findAll();
		for(Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("\n=== TEST 3: Department insert ===");
		Department newDepartment = new Department(null, "Music");
		DepartmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: Department update ===");
		Department dep2 = DepartmentDao.findById(1);
		dep2.setName("Food");
		DepartmentDao.update(dep2);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 6: Department delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		DepartmentDao.deletById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}
}
