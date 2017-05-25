package com.model.FilterPattern;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
public class OrCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria=criteria;
        this.otherCriteria=otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        System.out.println("meet your others too");
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        List<Person> otherCriteriaPersons = otherCriteria.meetCriteria(persons);

        otherCriteriaPersons.stream().filter(person -> firstCriteriaPersons.contains(person))
                .peek(person -> System.out.println("peek out "+person.getName()))
                .forEach(person -> firstCriteriaPersons.add(person));

        return firstCriteriaPersons;

    }
}
