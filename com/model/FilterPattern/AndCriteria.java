package com.model.FilterPattern;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/5/25.
 */
public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria,Criteria otherCriteria) {
        this.criteria=criteria;
        this.otherCriteria=otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        System.out.println("meet your others");
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
