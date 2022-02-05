package org.setronica.setronicapim.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

public class Product {
    private long id;
    private String name;
    private String description;
    private float price;

    /*TODO enum guide ->https://medium.com/javarevisited/an-effective-way-to-use-java-enums-in-your-spring-application-485c969794a8*/
    private String currency;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;


}
