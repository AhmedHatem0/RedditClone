package com.example.reddit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor

public class Link {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String url;

}
