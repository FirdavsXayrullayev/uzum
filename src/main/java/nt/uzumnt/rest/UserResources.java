package nt.uzumnt.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import nt.uzumnt.dto.ResponseDto;
import nt.uzumnt.dto.UsersDto;
import nt.uzumnt.service.UsersService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResources {

    private final UsersService usersService;

    @PostMapping
    public ResponseDto<UsersDto> add(@RequestBody UsersDto dto){
        return usersService.add(dto);
    }
}
