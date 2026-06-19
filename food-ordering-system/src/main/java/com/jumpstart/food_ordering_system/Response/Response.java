package com.jumpstart.food_ordering_system.Response;

/*
 *This generic class wrap the responses of all endpoints
 *This enables us to have a structured format for every response
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private String message;
    private T data;
    private int statusCode;
    private LocalDateTime timestamp;

    /*
       Generic method for a success response
     */
    public static <T>  Response<T> success(int statusCode, String message, T data)
    {
          return Response.<T>builder()
                  .statusCode(statusCode)
                  .message(message)
                  .data(data)
                  .timestamp(LocalDateTime.now())
                  .build();
    }
    /*
     *Generic method for error response
     */
    public static  <T> Response<T>   error(int code, String message)
    {
        return  Response.<T>builder()
                .statusCode(code)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
