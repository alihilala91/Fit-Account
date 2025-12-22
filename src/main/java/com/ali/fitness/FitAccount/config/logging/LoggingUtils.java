package com.ali.fitness.FitAccount.config.logging;

import com.ali.fitness.FitAccount.config.FilteringRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * Author Ali Hilal
 * Date 1/21/2024
 */
@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class LoggingUtils {
    private static final String redColor = "\u001B[31m";
    private static final String greenColor = "\u001B[32m";
    private static final String yellowColor = "\u001B[33m";
    private static final String defaultColor = "\u001B[0m";

    /**
     * Log with Level Info
     *
     * @param message     Log message
     * @param messageBody message body
     */
    public static void logInfo(final String message, final Object messageBody) {
        if (messageBody != null) {
            log.info(String.format("%s%s%s",
                    greenColor,
                    LogResponse.builder()
                            .requestId(FilteringRequest.requestId.get())
                            .message(message)
                            .messageBody(messageBody.toString())
                            .build().toString(),
                    defaultColor));
        }
    }


    /**
     * Log with Level Info
     *
     * @param message Log message
     */
    public static void logInfo(final String message) {
        log.info(String.format("%s[%s]%s",
                greenColor,
                LogResponse.builder()
                        .requestId(FilteringRequest.requestId.get())
                        .message(message)
                        .build().toString(),
                defaultColor));

    }

    /**
     * Log with Level Error
     *
     * @param exception Exception
     */
    public static void logError(final Exception exception) {
        log.error(String.format("%s[%s]%s",
                redColor,
                LogResponse.builder()
                        .requestId(FilteringRequest.requestId.get())
                        .message(exception.getMessage())
                        .messageBody(exception.getMessage())
                        .build().toString(),
                defaultColor));
    }

    /**
     * Log with Level Warn
     *
     * @param message     Log Message
     * @param messageBody Message Body
     */
    public static void logWarn(final String message, final Object messageBody) {
        if (messageBody != null) {
            log.warn(String.format("%s[%s]%s",
                    yellowColor,
                    LogResponse.builder()
                            .requestId(FilteringRequest.requestId.get())
                            .message(message)
                            .messageBody(messageBody.toString())
                            .build().toString(),
                    defaultColor));

        }

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class LogResponse {
        private String requestId;
        private String message;
        private Object messageBody;

        @Override
        public String toString() {
            return "{" +
                    "requestId='" + requestId + '\'' +
                    ", message='" + message + '\'' +
                    ", messageBody=" + messageBody +
                    '}';
        }
    }
}
