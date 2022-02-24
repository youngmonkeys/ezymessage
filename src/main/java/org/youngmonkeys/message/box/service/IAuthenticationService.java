package org.youngmonkeys.message.box.service;

public interface IAuthenticationService {

    long verifyAccessToken(String accessToken);

    String generateAccessToken(long userId);

    void removeAccessToken(String accessToken);
}
