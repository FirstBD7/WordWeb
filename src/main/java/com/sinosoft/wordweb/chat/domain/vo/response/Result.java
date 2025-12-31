package com.sinosoft.wordweb.chat.domain.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("基础返回体")
public class Result<T> {
    @ApiModelProperty("成功标识true or false")
    private Boolean success;
    @ApiModelProperty("错误码")
    private Integer errCode;
    @ApiModelProperty("错误信息")
    private String errMsg;
    @ApiModelProperty("返回对象")
    private T data;

    public static <T> Result<T> success(T data)
    {
        Result<T> result = new Result<>();
        result.setSuccess(Boolean.TRUE);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success()
    {
        Result<T> result = new Result<>();
        result.setData(null);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> Result<T> fail(Integer code, String msg)
    {
        Result<T> result = new Result<>();
        result.setErrCode(code);
        result.setErrMsg(msg);
        result.setSuccess(Boolean.FALSE);
        return result;
    }
}
