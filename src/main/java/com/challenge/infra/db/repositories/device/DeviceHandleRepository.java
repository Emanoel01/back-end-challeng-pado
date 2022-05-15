package com.challenge.infra.db.repositories.device;
import com.challenge.infra.db.entities.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceHandleRepository extends JpaRepository<DeviceEntity, Long> {
}
