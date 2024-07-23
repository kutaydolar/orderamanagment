package com.example.main;

import com.example.dao.ProductDAO;
import com.example.entity.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/ordermanagament";
        String user = "postgres";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            ProductDAO productDAO = new ProductDAO(conn);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n*** CRUD Uygulaması ***");
                System.out.println("1. Kayıt Ekle");
                System.out.println("2. Kayıtları Listele");
                System.out.println("3. Kayıt Güncelle");
                System.out.println("4. Kayıt Sil");
                System.out.println("5. Kayıt Ara");
                System.out.println("6. Çıkış");
                System.out.print("Seçiminiz (1-6): ");

                int secim = scanner.nextInt();
                scanner.nextLine(); // Dummy nextLine to consume newline character

                switch (secim) {
                    case 1:
                        System.out.println("Ürün Bilgilerini Girin:");
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Description: ");
                        String description = scanner.nextLine();
                        System.out.print("Category: ");
                        String category = scanner.nextLine();
                        System.out.print("Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Stock Quantity: ");
                        int stockQuantity = scanner.nextInt();
                        System.out.print("Is Active (true/false): ");
                        boolean isActive = scanner.nextBoolean();

                        Product newProduct = new Product(0, name, description, category, price, stockQuantity, isActive);
                        productDAO.insert(newProduct);
                        break;
                    case 2:
                        List<Product> productList = productDAO.getAllProducts();
                        System.out.println("\n--- Tüm Ürünler ---");
                        for (Product product : productList) {
                            System.out.println(product);
                        }
                        break;
                    case 3:
                        System.out.print("Güncellenecek Ürünün ID'sini Girin: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine(); // Dummy nextLine to consume newline character

                        Product existingProduct = productDAO.getProductById(updateId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
