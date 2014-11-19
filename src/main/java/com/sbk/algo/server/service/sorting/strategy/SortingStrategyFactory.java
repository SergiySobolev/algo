package com.sbk.algo.server.service.sorting.strategy;

import com.sbk.algo.shared.enums.SortingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * Created by sobik on 19/11/2014.
 */
@Component(value = "sortingStrategyFactory")
@Scope("singleton")
public class SortingStrategyFactory {

    @Autowired
    private ApplicationContext context;

    public SortingStrategy getStrategy(SortingType sortingType) {
        Map<String, Object> sortStrategyBeans = context.getBeansWithAnnotation(SortStrategy.class);
        Assert.notEmpty(sortStrategyBeans, "No strategies found for sorting type '" + sortingType.getCode()
                + "', are the strategies marked with @SortStrategy?");
        for (Object sortStrategyBean : sortStrategyBeans.values()) {
            SortStrategy sortStrategyAnnotation
                    = sortStrategyBean.getClass().getAnnotation(SortStrategy.class);
            if (sortingType == sortStrategyAnnotation.sortingType()) {
                return (SortingStrategy) sortStrategyBean;
            }
        }
        return null;
    }
}
