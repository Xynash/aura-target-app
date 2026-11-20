package io.aura.payment;

public class PaymentService {

    private static double taxRate = 0.18;

    public double processPayment(String userId, double amount) {
        // BUG: No null check on userId - throws NullPointerException
        if (userId == null) {
            throw new IllegalArgumentException("userId must not be null");
        }
        System.out.println("Processing for: " + userId.toUpperCase());

        // BUG: getCartItems returns 0 for guest users - ArithmeticException
        int cartItems = getCartItems(userId);
        if (cartItems <= 0) {
            throw new IllegalArgumentException(
                "Cart items must be greater than zero for userId: " + userId);
        }
        double perUnit = amount / cartItems;
        return perUnit * (1 + taxRate);
    }

    private int getCartItems(String userId) {
        if (userId.startsWith("guest")) return 0;
        return 3;
    }

    public void refund(String transactionId) {
        // BUG: No bounds check on split result
        if (transactionId == null) {
            throw new IllegalArgumentException("transactionId must not be null");
        }
        String[] parts = transactionId.split("-");
        if (parts.length < 3) {
            throw new IllegalArgumentException(
                "transactionId must contain at least three dash‑separated parts");
        }
        System.out.println("Refunding: " + parts[2]);
    }
}
