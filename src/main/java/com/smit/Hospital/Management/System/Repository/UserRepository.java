package com.smit.Hospital.Management.System.Repository;

import com.smit.Hospital.Management.System.Entity.User;
import com.smit.Hospital.Management.System.Entity.type.AuthProviderType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByProviderIdAndProviderType(String providerId, AuthProviderType authProviderType);

}
