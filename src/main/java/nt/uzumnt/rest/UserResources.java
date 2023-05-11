package nt.uzumnt.rest;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    @PatchMapping()
    public ResponseDto<UsersDto> updateUser(@RequestBody UsersDto dto){
        return usersService.updateUser(dto);
    }
    @GetMapping("phone-number")
    public ResponseDto<UsersDto> findByPhoneNumber(@RequestParam String phoneNumber){
        return usersService.findPhoneNumber(phoneNumber);
    }
    @DeleteMapping("/{id}")
    public ResponseDto<UsersDto> deleteById(@PathVariable Integer id){
        return usersService.deleteById(id);
    }
}
