package com.homecare.Homecare.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private Integer code;
    private Boolean success;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer total;

    public BaseResponse(Integer code, Boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }

}
