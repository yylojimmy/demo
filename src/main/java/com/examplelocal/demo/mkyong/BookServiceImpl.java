package com.examplelocal.demo.mkyong;

import com.examplelocal.demo.dto.Book;
import com.examplelocal.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book selectBook(int id) {
        return bookMapper.selectBook(id);
    }
}
