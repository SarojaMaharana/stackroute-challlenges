package com.stackroute.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* Add Annotation to declare this class as a JPA Entity */
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Blog {
    /*Add Annotation to declare this field as a Unique Identifier */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int blogId;
    private String blogTitle;
    private String authorName;
    private String blogContent;

    /* Generate no-arg and parametrized consructor */


}
