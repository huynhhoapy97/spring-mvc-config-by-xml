package com.huynhhoapy97.controllers;

import com.huynhhoapy97.models.Brand;
import com.huynhhoapy97.models.Product;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        // Using ApplicationContext to get Bean
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        Brand brand = (Brand) context.getBean("brand");

        // Using BeanFactory to get Bean
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-beans.xml"));
        Product product = (Product) beanFactory.getBean("product");

        System.out.println(brand);
        System.out.println(product);

        return "hello";
    }
}
