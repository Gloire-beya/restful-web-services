package com.glory.restful.webservices.restfulwebservices.versionning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
    //URI versioning
    @GetMapping("/v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Glory Beya");
    }
    @GetMapping("/v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Glory", "Beya"));
    }

    //request params versioning
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("James Mwamba");
    }
    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("James", "Mwamba"));
    }

    //headers versioning
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Teboho Malimabe");
    }
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Teboho", "Malimabe"));
    }

    //produces versioning
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Jeanluc Megolo");
    }
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Jeanluc", "Megolo"));
    }
}
