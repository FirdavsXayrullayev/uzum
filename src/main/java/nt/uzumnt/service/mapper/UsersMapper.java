package nt.uzumnt.service.mapper;

import nt.uzumnt.dto.UsersDto;
import nt.uzumnt.model.Users;

public class UsersMapper {

    public static Users toUser(UsersDto dto){
        Users entity = new Users();

        entity.setBirtDate(dto.getBirtDate());
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setGender(dto.getGender());
        entity.setId(dto.getId());
        entity.setLastName(dto.getLastName());
        entity.setMiddleName(dto.getMiddleName());
        entity.setPhoneNumber(dto.getPhoneNumber());

        return entity;
    }
    public static UsersDto toDto(Users entity){
        UsersDto dto = new UsersDto();

        dto.setBirtDate(entity.getBirtDate());
        dto.setEmail(entity.getEmail());
        dto.setFirstName(entity.getFirstName());
        dto.setGender(entity.getGender());
        dto.setId(entity.getId());
        dto.setLastName(entity.getLastName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setPhoneNumber(entity.getPhoneNumber());

        return dto;
    }
}
