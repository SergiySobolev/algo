package com.sbk.algo.server.service.sorting.strategy;

import com.sbk.algo.shared.enums.SortingType;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by sobik on 19/11/2014.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface SortStrategy {
    Class type();

    SortingType sortingType();
}
