package com.challenge.infra.db.ports;

import com.challenge.infra.db.entities.DeviceEntity;

public interface CreateDeviceRepository {

    DeviceEntity create(DeviceEntity entity);

}
