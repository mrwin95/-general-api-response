package win.ddd.response.util;

import win.ddd.response.response.ApiResponse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResponseUtil {

    public static <T>ApiResponse<T> success(T data, String msg, String path) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage(msg);
        response.setData(data);
        response.setErrors(null);
        response.setErrorCode(0); // No error
        response.setTimestamp(System.currentTimeMillis());
        response.setPath(path);
        return response;
    }

    public static <T>ApiResponse<T> error(List<String> errors, String msg, int errorCode, String path) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setMessage(msg);
        response.setData(null);
        response.setErrors(errors);
        response.setErrorCode(errorCode); // No error
        response.setTimestamp(System.currentTimeMillis());
        response.setPath(path);
        return response;
    }

    public static <T>ApiResponse<T> error(String error, String msg, int errorCode, String path) {
        return error(Collections.singletonList(error), msg, errorCode, path);
    }

}
