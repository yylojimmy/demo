package com.examplelocal.demo;

import com.examplelocal.demo.dto.Book;
import com.examplelocal.demo.mkyong.BookRepository;
import com.examplelocal.demo.mkyong.BookService;
import com.examplelocal.demo.redis.RedisConstants;
import com.examplelocal.demo.redis.RedisUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication implements CommandLineRunner {


    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookService bookService;

    @Autowired
    RedisUtil redisUtil;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        repository.save(new Book("Java"));
        repository.save(new Book("Node"));
        repository.save(new Book("Python"));

        System.out.println("\nfindAll()");
        repository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nfindById(1L)");
        repository.findById(1l).ifPresent(x -> System.out.println(x));

        System.out.println("\nfindByName('Node')");
        repository.findByName("Node").forEach(x -> System.out.println(x));

        Book b = bookService.selectBook(1);
        System.out.println("b = "+b.getName());

        //redisUtil.set("20182018","这是一条测试数据", RedisConstants.datebase1);
        //Long resExpire = redisUtil.expire("20182018", 60, RedisConstants.datebase1);//设置key过期时间
        //System.out.println("resExpire="+resExpire);
        String res = redisUtil.get("20182018", RedisConstants.datebase1);

        System.out.println("redus 热搜= "+res);

    }

}
