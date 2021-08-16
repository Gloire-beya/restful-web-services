package com.glory.restful.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);

        return mapping;
    }
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveAllSomeBean(){
        List<SomeBean> beans = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                                                 new SomeBean("value1", "value2", "value3"));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3", "field1");
        FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(beans);
        mapping.setFilters(filters);
        return mapping;
    }

}
