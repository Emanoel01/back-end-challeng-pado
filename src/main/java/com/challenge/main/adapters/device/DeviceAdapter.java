package com.challenge.main.adapters.device;

import com.challenge.domain.models.Device;
import com.challenge.infra.db.entities.DeviceEntity;
import com.challenge.presentation.controllers.responses.device.RegistrateDeviceResponse;
import com.challenge.presentation.dto.device.DeviceDto;
import org.springframework.beans.BeanUtils;

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

    public static RegistrateDeviceResponse adaptDeviceToRegistrateDeviceResponse(Device device){
        RegistrateDeviceResponse response = new RegistrateDeviceResponse();
        response.setMac(device.getMac());
        response.setDeviceId(device.getDeviceId());
        return response;
    }

    public static Device adaptDeviceDtoToDevice(DeviceDto deviceDto){
        Device device = new Device();
        BeanUtils.copyProperties(deviceDto, device);
        return device;
    }

}
