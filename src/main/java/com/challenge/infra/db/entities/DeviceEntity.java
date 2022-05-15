package com.challenge.infra.db.entities;


import lombok.Cleanup;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="device")
@Data
public class DeviceEntity {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private UUID deviceId;

    @Column
    private String name;

    @Column
    private String mac;

    @Column
    private String email;

    @Column
    private Double latitude;

    @Column
    private  Double longitude;
}
