package com.formation.banking.dto;

import com.formation.banking.models.Address;
import com.formation.banking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AddressDto {

    private Integer id;

    private String country;

    private String city;

    private String street;

    private String zipCode;

    private Integer houseNumber;

    private Integer userId;

    public static AddressDto fromEntity(Address address){
        return AddressDto.builder()
                .id(address.getId())
                .country(address.getCountry())
                .city(address.getCity())
                .street(address.getStreet())
                .zipCode(address.getZipCode())
                .houseNumber(address.getHouseNumber())
                .userId(address.getUser().getId())
                .build();
    }

    public static Address toEntity(AddressDto address){
        return Address.builder()
                .id(address.getId())
                .country(address.getCountry())
                .city(address.getCity())
                .street(address.getStreet())
                .zipCode(address.getZipCode())
                .houseNumber(address.getHouseNumber())
                .user(
                        User.builder()
                            .id(address.getUserId())
                            .build()
                )
                .build();
    }
}
