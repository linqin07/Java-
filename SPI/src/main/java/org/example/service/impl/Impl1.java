package org.example.service.impl;

import org.example.service.Search;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/11/27
 */
public class Impl1 implements Search {
    @Override
    public String doSomeThing(String args) {
        System.out.println("impl1");
        return args;
    }
}
