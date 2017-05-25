package com.model.FilterPattern;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
