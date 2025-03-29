package com.compi.elitewings.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flights")

public class Flight {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "celebrity_id", nullable = false)
    private Celebrity celebrity;

    @ManyToOne
    @JoinColumn(name = "jet_id", nullable = false)
    private PrivateJet privateJet;

    @Column(nullable = false)
    private String departure_airport;

    @Column(nullable = false)
    private String arrival_airport;

    @Column(nullable = false)
    private LocalDateTime departure_time;

    @Column(nullable = false)
    private LocalDateTime arrival_time;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Purpose purpose;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SecurityReport> securityReports = new ArrayList<>();

    public enum Purpose {
        BUSINESS, VACATION, SUSPICIOUS
    }
}
