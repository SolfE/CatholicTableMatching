package com.csec.CatholicTableMatching.domain;

import jakarta.persistence.*;

@Entity
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foodType; // "Korean", "Chinese", "Japanese", "Western"
    private String timeSlot; // "Morning", "Afternoon", "Evening"
    private String preferredGender; // 'M', 'F', or 'Any'

    // Other fields and methods
}

// 이걸 버릴계획