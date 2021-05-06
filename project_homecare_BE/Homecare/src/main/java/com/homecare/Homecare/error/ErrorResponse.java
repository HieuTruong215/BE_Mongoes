package com.homecare.Homecare.error;

import com.homecare.Homecare.response.BaseResponse;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ErrorResponse extends BaseResponse {

    public ErrorResponse(Integer code, String message) {
        super(code, false, message);
    }
}
