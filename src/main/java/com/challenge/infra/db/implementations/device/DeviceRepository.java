package com.challenge.infra.db.implementations.device;

import com.challenge.infra.db.entities.DeviceEntity;
import com.challenge.infra.db.ports.CreateDeviceRepository;
import com.challenge.infra.db.repositories.device.DeviceHandleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceRepository implements CreateDeviceRepository {

    @Autowired
    DeviceHandleRepository deviceHandleRepository;

    @Override
    public DeviceEntity create(DeviceEntity entity) {
        return this.deviceHandleRepository.save(entity);
    }
}
