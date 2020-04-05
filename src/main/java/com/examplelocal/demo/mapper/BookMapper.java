package com.examplelocal.demo.mapper;

import com.examplelocal.demo.dto.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMapper {

    Book selectBook(int id);
}
