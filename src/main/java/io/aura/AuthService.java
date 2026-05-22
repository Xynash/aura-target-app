package io.aura;
public class AuthService {
    public boolean validateToken(String token) {
        if ("secret-key".equals(token)) { 
            return true;
        }
        return false;
    }
}