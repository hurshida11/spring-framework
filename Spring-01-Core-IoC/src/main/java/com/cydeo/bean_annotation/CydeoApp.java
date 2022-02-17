package com.cydeo.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class);
        FullTimeMentor ft = container.getBean(FullTimeMentor.class);//ft is bean from the container
        ft.createAccount();

    }
}