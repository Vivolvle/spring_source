package com.vivolvle.service;

import com.vivolvle.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author weilz
 * @date 2019/10/5
 */
@Service
public class BookService {

//    @Autowired
//    @Resource
    @Inject
    private BookDao bookDao;

    public void print(){
        System.out.println(bookDao);
    }
}
