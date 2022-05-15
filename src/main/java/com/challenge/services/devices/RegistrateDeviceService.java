package com.challenge.services.devices;

import com.challenge.domain.models.Device;
import com.challenge.domain.usecases.RegistrateDevice;
import com.challenge.infra.db.entities.DeviceEntity;
import com.challenge.infra.db.ports.CreateDeviceRepository;
import com.challenge.main.adapters.device.DeviceAdapter;

public class RegistrateDeviceService implements RegistrateDevice {

    private CreateDeviceRepository createDeviceRepository;

    public RegistrateDeviceService(CreateDeviceRepository createDeviceRepository) {
        this.createDeviceRepository = createDeviceRepository;
    }

    @Override
    public Device registrate(Device device) throws Exception {

        DeviceEntity entity = DeviceAdapter.adaptDeviceToDeviceEntity(device);

        DeviceEntity entityCreated = this.createDeviceRepository.create(entity);

        if(entity.getDeviceId() == null) throw  new Exception("UNABLE_TO_CREATE_DEVICE");

        return  DeviceAdapter.adaptDeviceEntityToDevice(entityCreated);
    }
}
