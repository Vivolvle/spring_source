package com.vivolvle;

import com.vivolvle.bean.Boss;
import com.vivolvle.bean.Color;
import com.vivolvle.config.MainConfigOfAutowired;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liangzheng.wei
 * @Description:
 * @date 2019/10/12 15:10
 * @Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */
public class IOCTest_Autowired {
    @Test
    public void test01() {
        //创建ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
//        BookService bookService = context.getBean(BookService.class);
//        bookService.print();
//        System.out.println(context.getBean(BookDao.class));
        Boss boss = context.getBean(Boss.class);
        System.out.println(boss);
        Color color = context.getBean(Color.class);
        System.out.println(color);
    }
}
