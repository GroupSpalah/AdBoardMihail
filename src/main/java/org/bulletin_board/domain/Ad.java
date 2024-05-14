package org.bulletin_board.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Ad {

    @Version
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_id")
    int id;

    String name;

    LocalDate date;

    String text;

    @Column(name = "cost_service")
    int costService;

    @ManyToOne
    @JoinColumn(name = "FK_Ad_Category")
    Category category;

    @ManyToOne
    @JoinColumn(name = "FK_Ad_Author")
    Author author;

}
