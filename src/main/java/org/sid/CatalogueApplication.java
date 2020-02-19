package org.sid;

import org.sid.dao.CategoryRepository;
import org.sid.dao.ProductRepository;
import org.sid.entities.Category;
import org.sid.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class CatalogueApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogueApplication.class, args);

    }
    @Bean
    CommandLineRunner start(CategoryRepository categoryRepository,ProductRepository productRepository){
        return args -> {
           categoryRepository.deleteAll();
            /* Stream.of("C1 Ordinateur","C2 Imprimante").forEach(c->{categoryRepository.save(new Category(c.split(" ")[0],c.split(" ")[1],new ArrayList<>()));
            });
            categoryRepository.findAll().forEach(System.out::println);*/

           // Category   category= new Category(" ","Ordinateur",new ArrayList<>());

            Category c1=  categoryRepository.save(new Category("C1","Ordinateur",new ArrayList<>()));

            Category c2= categoryRepository.save(new Category("C2","Imprimante",new ArrayList<>()));

            Category c3=  categoryRepository.save(new Category("C3","Chargeur",new ArrayList<>()));

            categoryRepository.findAll().forEach(System.out::println);

            productRepository.deleteAll();

           // Category c1=categoryRepository.findById("C1").get();
            //Category c2=categoryRepository.findById("C2").get();


//         Product p= productRepository.save(new Product(null ,"P1",Math.random()*1000,c1));
//         c1.getProducts().add(p);
//
//          categoryRepository.save(c1);

          /* Product p2= productRepository.save(new Product(null ,"P2",Math.random()*1000,c2));
           c2.getProducts().add(p2);

           categoryRepository.save(c2);

            Product p3= productRepository.save(new Product(null ,"P3",Math.random()*1000,c2));
            c3.getProducts().add(p3);
            c1.getProducts().add(p3);
            categoryRepository.save(c1);

            categoryRepository.save(c3);*/
            productRepository.findAll().forEach(System.out::println);



        };
    }
}
