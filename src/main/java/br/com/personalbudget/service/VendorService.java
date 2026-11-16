package br.com.personalbudget.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.personalbudget.model.entity.User;
import br.com.personalbudget.model.entity.Vendor;
import br.com.personalbudget.repository.UserRepository;
import br.com.personalbudget.repository.VendorRepository;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class VendorService {
    private final VendorRepository vendorRepository;
    private final UserRepository userRepository;

    @Transactional
    public Vendor findOrCreate (String vendorName, UUID userId){
        String normalizedName = vendorName.trim();

        return vendorRepository.findByNameIgnoreCaseAndUserId(normalizedName, userId).orElseGet(() -> {
            Vendor vendor = new Vendor();
            vendor.setName(normalizedName);

            User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário Não Encontrado"));

            vendor.setUser(user);

            return vendorRepository.save(vendor);        
        });

    }

}
