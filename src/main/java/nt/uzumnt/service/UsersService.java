package nt.uzumnt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import nt.uzumnt.dto.ResponseDto;
import nt.uzumnt.dto.UsersDto;
import nt.uzumnt.model.Users;
import nt.uzumnt.repository.UserRepository;
import nt.uzumnt.service.mapper.UsersMapper;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository userRepository;

    public ResponseDto<UsersDto> add(UsersDto dto){
        dto.setIsActive((short) 1);
        Users users = UsersMapper.toUser(dto);
        userRepository.save(users);

        return ResponseDto.<UsersDto>builder()
                .success(true)
                .massage("Ok")
                .data(UsersMapper.toDto(users))
                .build();
    }
    public ResponseDto<UsersDto> updateUser(UsersDto dto){
        if(dto.getId() == null){
            return ResponseDto.<UsersDto>builder()
                    .code(2)
                    .massage("Id null")
                    .data(dto)
                    .build();
        }
        Optional<Users> optionalUsers = userRepository.findFirstByIdAndIsActive(dto.getId(), (short) 1);
        if(optionalUsers.isEmpty()){
            return ResponseDto.<UsersDto>builder()
                    .massage("Not found " + dto.getId())
                    .code(-1)
                    .data(dto)
                    .success(false)
                    .build();
        }
        Users users = optionalUsers.get();
//        if(users.getIsActive() == 0) {
//            return ResponseDto.<UsersDto>builder()
//                    .massage("This Id not active " + dto.getId())
//                    .code(-1)
//                    .data(dto)
//                    .success(false)
//                    .build();
//        }
            users.setId(dto.getId());
            if (dto.getBirtDate() != null) {
                users.setBirtDate(dto.getBirtDate());
            }
            if (dto.getEmail() != null) {
                users.setEmail(dto.getEmail());
            }
            if (dto.getGender() != null) {
                users.setGender(dto.getGender());
            }
            if (dto.getFirstName() != null) {
                users.setFirstName(dto.getFirstName());
            }
            if (dto.getLastName() != null) {
                users.setLastName(dto.getLastName());
            }
            if (dto.getMiddleName() != null) {
                users.setMiddleName(dto.getMiddleName());
            }
            if (dto.getPhoneNumber() != null) {
                users.setPhoneNumber(dto.getPhoneNumber());
            }
            try {
                userRepository.save(users);
                return ResponseDto.<UsersDto>builder()
                        .massage("Ok")
                        .data(UsersMapper.toDto(users))
                        .success(true)
                        .build();
            } catch (Exception e) {
                return ResponseDto.<UsersDto>builder()
                        .code(-1)
                        .massage("Not found")
                        .success(false)
                        .data(dto)
                        .build();
            }
    }
    public ResponseDto<UsersDto> findPhoneNumber(String phoneNumber){
        return userRepository.findFirstByPhoneNumberAndIsActive(phoneNumber, (short) 1)
                .map(u-> ResponseDto.<UsersDto>builder()
                        .massage("Ok")
                        .success(true)
                        .code(0)
                        .data(UsersMapper.toDto(u))
                        .build())
                .orElse(ResponseDto.<UsersDto>builder()
                        .massage("Not found " + phoneNumber)
                        .code(-1)
                        .build()
                );
    }
    public ResponseDto<UsersDto> deleteById(Integer id){
        Optional<Users> optionalUsers = userRepository.findById(id);
        if(optionalUsers.isEmpty()){
            return ResponseDto.<UsersDto>builder()
                    .massage("Not found " + id)
                    .code(-1)
                    .success(false)
                    .build();
        }
        Users users = optionalUsers.get();
        if(users.getIsActive() == 1){
            users.setIsActive((short) 0);
            userRepository.save(users);
            return ResponseDto.<UsersDto>builder()
                    .code(0)
                    .massage("Ok")
                    .success(true)
                    .build();
        }
        return ResponseDto.<UsersDto>builder()
                .massage("Not found " + id)
                .code(-1)
                .success(false)
                .build();
    }
}
