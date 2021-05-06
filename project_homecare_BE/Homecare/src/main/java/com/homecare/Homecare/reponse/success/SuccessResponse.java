package com.homecare.Homecare.reponse.success;

import com.homecare.Homecare.response.BaseResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse<T> extends BaseResponse {
    private T data;

    public SuccessResponse() {
        super(200, true, "success");
    }

    public SuccessResponse(T data) {
        super(200, true, "success");
        this.data = data;
    }

    public SuccessResponse(T data, Integer total) {
        super(200, true, "success");
        this.setTotal(total);
        this.data = data;
    }
}
