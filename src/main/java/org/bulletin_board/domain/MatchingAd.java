package org.bulletin_board.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class MatchingAd {
    @Version
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matching_ad_id")
    int id;

    @Column(name = "price_from")
    double priceFrom;

    @Column(name = "price_to")
    double priceTo;

    @ManyToOne
    @JoinColumn(name = "FK_Matching_Ad_Author")
    Author author;

    @ManyToOne
    @JoinColumn(name = "FK_Matching_Ad_Category")
    Category category;

    String tittle;

}
