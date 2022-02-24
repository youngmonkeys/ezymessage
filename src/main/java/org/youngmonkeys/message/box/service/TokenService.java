package org.youngmonkeys.message.box.service;

import com.google.common.hash.Hashing;
import com.tvd12.ezyhttp.server.core.annotation.Service;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

@Service
public class TokenService {
    public String getTokenByServiceName(String serviceName) throws NoSuchAlgorithmException {
        UUID uuid = UUID.randomUUID();
        Date date = new Date();
        String originalString = date.toString() + uuid + serviceName;
        return Hashing.sha256()
                .hashString(originalString, StandardCharsets.UTF_8)
                .toString();
    }
}
