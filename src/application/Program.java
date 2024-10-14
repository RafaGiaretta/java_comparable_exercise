package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import services.CalculationService;

public class Program {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();

		String path = "C:\\Users\\rafae\\OneDrive\\Ambiente de Trabalho\\Curso Java\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				if (fields.length == 2) {
					String name = fields[0];
					double price = Double.parseDouble(fields[1]);
					list.add(new Product(name, price));
				}
				line = br.readLine();
			}

			Product x = CalculationService.max(list);
			System.out.println("Max: ");
			System.out.println(x);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
