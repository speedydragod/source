package com.model.FilterPattern;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/5/25.
 */
public class CriteriaMale implements Criteria {


    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        System.out.println("filter male before");

        return persons.stream().filter(person -> person.getGender().equalsIgnoreCase("male"))
                .peek(person-> {
                    System.out.println("peek is "+person.getName());
                }).collect(Collectors.toList());

    }
}
