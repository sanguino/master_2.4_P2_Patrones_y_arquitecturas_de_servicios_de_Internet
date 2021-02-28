package es.urjc.code.ejem1.infrastructure.repository;

import es.urjc.code.ejem1.infrastructure.entity.CompletedCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataJPACompletedCartRepository extends JpaRepository<CompletedCartEntity, UUID> {

}
