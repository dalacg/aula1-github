package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.print("Quantos funcionarios gostaria de cadastrar? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Funcionario #" + (i + 1) + ":");
			System.out.print("ID: ");
			int id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();

			Employee emp = new Employee(id, name, salary);

			list.add(emp);
		}

		System.out.println();
		System.out.print("Qual o ID do funcionario que deseja reajustar o salario? ");
		int idSalary = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("Funciário não encontrado! ");
		} else {
			System.out.print("Qual a porcentagem? ");
			double percent = sc.nextDouble();
			emp.increaseSalary(percent);

		}

		System.out.println();
		System.out.println("Lista de empregados: ");
		for (int i = 0; i < n; i++) {
			System.out.println(emp);
		}

		sc.close();

	}

}
