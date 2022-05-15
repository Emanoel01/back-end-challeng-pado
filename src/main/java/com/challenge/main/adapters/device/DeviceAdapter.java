package com.challenge.main.adapters.device;

import com.challenge.domain.models.Device;
import com.challenge.infra.db.entities.DeviceEntity;
import com.challenge.presentation.dto.device.DeviceDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.validation.Validator;

public class DeviceAdapter {


    public static Device adaptDeviceEntityToDevice(DeviceEntity entity){

        Device device = new Device();
        BeanUtils.copyProperties(entity, device);
        return device;
    }

    public static DeviceEntity adaptDeviceToDeviceEntity(Device device){
        DeviceEntity entity = new DeviceEntity();
        BeanUtils.copyProperties(device, entity);
        return entity;
    }

    public static DeviceEntity adaptDeviceDtoToDeviceEntity(DeviceDto deviceDto){
        DeviceEntity entity = new DeviceEntity();
        BeanUtils.copyProperties(deviceDto, entity);
        return entity;
    }

}
