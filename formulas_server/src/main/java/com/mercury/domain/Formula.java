package com.mercury.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "formula")
public class Formula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "formula")
    private String formula;

    @ManyToOne(targetEntity = Theme.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id")
    private Theme theme;

}

