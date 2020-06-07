package com.compilednotes.blogsite.utils;

import org.dozer.DozerBeanMapper;

public class DozerBeanSingleton {

    private static DozerBeanMapper instance;

    private DozerBeanSingleton(){

    }

    public static DozerBeanMapper getInstance(){
        if( instance == null ){
            instance = new DozerBeanMapper();
        }
        return instance;
    }
}
