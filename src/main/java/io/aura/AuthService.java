package io.aura; 
 
public class AuthService { 
    public boolean validateToken(String token) { 
        System.out.println("Validating token..."); 
        if (token.equals("secret-key")) { 
            return true; 
        } 
        return false; 
    } 
} 
