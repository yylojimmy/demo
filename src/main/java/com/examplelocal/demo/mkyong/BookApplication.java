package com.examplelocal.demo.mkyong;

import com.examplelocal.demo.dto.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;




public class BookApplication implements CommandLineRunner {


    private static final Logger log = LoggerFactory.getLogger(BookApplication.class);

    @Autowired
    private BookRepository repository2;



    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        repository2.save(new Book("Java"));
        repository2.save(new Book("Node"));
        repository2.save(new Book("Python"));

        System.out.println("\nfindAll()");
        repository2.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nfindById(1L)");
        repository2.findById(1l).ifPresent(x -> System.out.println(x));

        System.out.println("\nfindByName('Node')");
        repository2.findByName("Node").forEach(x -> System.out.println(x));

    }

}
