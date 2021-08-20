package org.example.service;

import java.util.ServiceLoader;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/11/27
 */
public class MyServiceLoader extends ClassLoader {
    public static <S> ServiceLoader loadAll(final Class<S> clazz) {
        return ServiceLoader.load(clazz);
    }
}
