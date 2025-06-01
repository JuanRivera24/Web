package com.app.reviews.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reviews")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Relación con Service (asumiendo que tienes entidad Service)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(nullable = false)
    private int rating;  // Calificación (por ejemplo 1-5)

    @Column(length = 500)
    private String comment;  // Comentario opcional

    // Constructor vacío
    public Review() {}

    // Constructor con parámetros
    public Review(Long id, User user, Service service, int rating, String comment) {
        this.id = id;
        this.user = user;
        this.service = service;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters y setters se generan con @Data de Lombok
}
