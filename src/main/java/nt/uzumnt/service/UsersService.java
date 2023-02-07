package nt.uzumnt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import nt.uzumnt.dto.ResponseDto;
import nt.uzumnt.dto.UsersDto;
import nt.uzumnt.model.Users;
import nt.uzumnt.repository.UserRepository;
import nt.uzumnt.service.mapper.UsersMapper;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository userRepository;

    public ResponseDto<UsersDto> add(UsersDto dto){
        Users users = UsersMapper.toUser(dto);
        userRepository.save(users);

        return ResponseDto.<UsersDto>builder()
                .success(true)
                .massage("Ok")
                .data(UsersMapper.toDto(users))
                .build();
    }
}
