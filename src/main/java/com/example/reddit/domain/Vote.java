package com.example.reddit.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Vote extends Auditable {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private short direction;
    @NonNull
    @ManyToOne
    private Link link;


}
