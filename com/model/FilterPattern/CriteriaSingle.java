package com.model.FilterPattern;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/5/25.
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        System.out.println("filter Single before");

        return persons.stream().filter(person -> person.getMaritalStatus().equalsIgnoreCase("single"))
                .peek(person-> {
                    System.out.println("peek is "+person.getName());
                }).collect(Collectors.toList());

    }
}
