package br.com.personalbudget.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.personalbudget.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category, UUID> {
    Optional<Category> findByIdAndUserId(UUID categoryId, UUID UserId);

}
