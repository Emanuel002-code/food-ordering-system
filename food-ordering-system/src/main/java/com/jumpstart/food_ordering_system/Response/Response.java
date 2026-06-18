package com.jumpstart.food_ordering_system.Response;

/*
   This generic class wrap the responses of all endpoints
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

    @Getter
    @Setter
    private String message;
    @Setter
    @Getter
    private T data;
    @Setter
    @Getter
    private int statusCode;
    @Getter
    private LocalDateTime timestamp;
}
