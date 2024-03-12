package com.springboot.api.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_detail")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToOne(optional = false)
    @JoinColumn(name = "product_number")
    private Product product;
}
