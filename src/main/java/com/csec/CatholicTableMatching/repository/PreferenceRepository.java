package com.csec.CatholicTableMatching.repository;

import com.csec.CatholicTableMatching.domain.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}
// 이것도 일단 버릴계획