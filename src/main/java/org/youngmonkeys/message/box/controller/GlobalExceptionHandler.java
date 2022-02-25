package org.youngmonkeys.message.box.controller;

import com.tvd12.ezyfox.util.EzyLoggable;
import com.tvd12.ezyhttp.core.response.ResponseEntity;
import com.tvd12.ezyhttp.server.core.annotation.ExceptionHandler;
import com.tvd12.ezyhttp.server.core.annotation.TryCatch;
import org.youngmonkeys.message.box.exception.TokenExpiredException;
import org.youngmonkeys.message.box.exception.TokenNotFoundException;
import org.youngmonkeys.message.box.exception.UserNotFoundException;

@ExceptionHandler
public class GlobalExceptionHandler extends EzyLoggable {
    @TryCatch({TokenExpiredException.class, TokenNotFoundException.class})
    public ResponseEntity handleAccessTokenException(RuntimeException e) {
        logger.info("token error", e);
        return ResponseEntity.badRequest("token error");
    }

    @TryCatch(UserNotFoundException.class)
    public ResponseEntity handleUserNotFoundException(UserNotFoundException e) {
        logger.info("user not found", e);
        return ResponseEntity.notFound("user not found");
    }
}
