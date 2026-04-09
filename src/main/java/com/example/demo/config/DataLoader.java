package com.example.demo.config;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Product p1 = new Product();
                p1.setPname("Hyderabadi Chicken Biryani");
                p1.setPprice(350.0);
                p1.setPdescription("Authentic long-grain basmati rice cooked with tender chicken and secret spices.");

                Product p2 = new Product();
                p2.setPname("Paneer Butter Masala");
                p2.setPprice(280.0);
                p2.setPdescription("Rich and creamy cottage cheese cubes served in a velvet tomato gravy.");

                Product p3 = new Product();
                p3.setPname("Chicken Tikka Tandoori");
                p3.setPprice(320.0);
                p3.setPdescription("Smoky charcoal-grilled chicken marinated in yogurt and traditional tandoori tikka masala.");

                Product p4 = new Product();
                p4.setPname("Veg Manchurian");
                p4.setPprice(220.0);
                p4.setPdescription("Savory vegetable balls tossed in a tangy and spicy oriental soy-based sauce.");

                Product p5 = new Product();
                p5.setPname("Gulab Jamun (2pcs)");
                p5.setPprice(120.0);
                p5.setPdescription("Warm, soft milk-solid dumplings dipped in fragrant cardamom-infused sugar syrup.");

                Product p6 = new Product();
                p6.setPname("Lucknowi Biryani");
                p6.setPprice(450.0);
                p6.setPdescription("Royal Awadhi style biryani with aromatic Lucknowi spices and tender meat.");

                Product p7 = new Product();
                p7.setPname("Veg Chowmein");
                p7.setPprice(180.0);
                p7.setPdescription("Wok-fired noodles tossed with crisp garden veggies and toasted sesame oil.");

                Product p8 = new Product();
                p8.setPname("Kadai Paneer");
                p8.setPprice(310.0);
                p8.setPdescription("Fresh cottage cheese chunks cooked with bell peppers and ground Kadai spices.");

                Product p9 = new Product();
                p9.setPname("Rice Khir");
                p9.setPprice(120.0);
                p9.setPdescription("Traditional Indian rice pudding slow-cooked with saffron, milk and cardamom.");

                Product p10 = new Product();
                p10.setPname("Steamed Veggie Momo");
                p10.setPprice(140.0);
                p10.setPdescription("Delicate handcrafted dumplings filled with finely chopped fresh vegetables.");

                repository.saveAll(List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
                System.out.println("Sample products data seeded into database.");
            }
        };
    }
}
