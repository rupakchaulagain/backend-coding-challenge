package com.assignment.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "battery")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Battery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "post_code")
    private Long postcode;
    @Column(name = "capacity_in_watt")
    private Double capacityInWatt;

    @Override
    public String toString() {
        return "Battery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postcode=" + postcode +
                ", capacityInWatt=" + capacityInWatt +
                '}';
    }
}
