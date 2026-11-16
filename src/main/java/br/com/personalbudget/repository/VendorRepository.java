package br.com.personalbudget.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.personalbudget.model.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository <Vendor, UUID>{

    Optional<Vendor> findByNameIgnoreCaseAndUserId(
        String name,
        UUID userId
    );
}
