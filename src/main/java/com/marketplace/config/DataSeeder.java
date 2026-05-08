package com.marketplace.config;

import com.marketplace.model.Product;
import com.marketplace.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(ProductRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                String[][] data = {
                    {"Calculus Textbook", "12.99", "Riya Sharma", "Books", "Used but great condition, 3rd edition", "https://images.unsplash.com/photo-1544947950-fa07a98d237f?w=400", "5"},
                    {"Scientific Calculator", "8.50", "Arjun Patel", "Electronics", "Casio fx-991, perfect for exams", "https://images.unsplash.com/photo-1611532736597-de2d4265fba3?w=400", "3"},
                    {"Physics Lab Manual", "5.00", "Priya Nair", "Books", "Annotated with helpful notes", "https://images.unsplash.com/photo-1507842217343-583bb7270b66?w=400", "2"},
                    {"Laptop Stand", "15.00", "Karan Mehta", "Electronics", "Adjustable aluminium stand", "https://images.unsplash.com/photo-1527864550417-7fd91fc51a46?w=400", "4"},
                    {"Engineering Drawing Kit", "10.00", "Sneha Rao", "Stationery", "Full set, barely used", "https://images.unsplash.com/photo-1583845112203-29329902332e?w=400", "6"},
                    {"Python Programming Book", "9.99", "Dev Kumar", "Books", "Learn Python the Hard Way, 4th Ed", "https://images.unsplash.com/photo-1550439062-609e1531270e?w=400", "3"},
                    {"Mechanical Keyboard", "35.00", "Ananya Singh", "Electronics", "Blue switches, great for typing", "https://images.unsplash.com/photo-1587829741301-dc798b83add3?w=400", "1"},
                    {"Desk Lamp", "11.00", "Rohit Verma", "Furniture", "LED, adjustable neck, USB charging", "https://images.unsplash.com/photo-1507473885765-e6ed057f782c?w=400", "7"},
                };

                for (String[] d : data) {
                    Product p = new Product();
                    p.setName(d[0]);
                    p.setPrice(Double.parseDouble(d[1]));
                    p.setSeller(d[2]);
                    p.setCategory(d[3]);
                    p.setDescription(d[4]);
                    p.setImageUrl(d[5]);
                    p.setStock(Integer.parseInt(d[6]));
                    repo.save(p);
                }
            }
        };
    }
}
