package com.example.msscbeerservice.persistence;


import com.example.msscbeerservice.web.model.BeerStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID id;

    @Column
    private Integer version;

    @Column
    private OffsetDateTime createdDate;

    @Column
    private OffsetDateTime lastModifieddate;

    @Column
    private String beerName;

    @Column
    private BeerStyleEnum beerStyle;

    @Column
    private Long upc;

    @Column
    private BigDecimal price;

    @Column
    private Integer quantityOnHand;

}
