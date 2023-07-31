package com.example.mobile.repository;

import com.example.mobile.model.Favorite;
import com.example.mobile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    List<Favorite> findAllByUserId(Integer userId);
}
