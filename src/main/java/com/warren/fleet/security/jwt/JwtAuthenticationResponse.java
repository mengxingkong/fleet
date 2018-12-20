package com.warren.fleet.security.jwt;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = 4784951536404964122L;
    private final String token;   //要发送回客户端的令牌

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
}
}