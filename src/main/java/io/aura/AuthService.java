package io.aura;

public class AuthService {

    public boolean validateToken(String token) {
        // Fix: Yoda condition prevents NullPointerException
        if ("secret-key".equals(token)) return true;
        return false;
    }
}