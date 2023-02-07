package nt.uzumnt.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class ResponseDto <T>{
    private int code;
    private String massage;
    private T data;
    private boolean success;
}
