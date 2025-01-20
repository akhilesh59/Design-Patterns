package StructuralDesignPattern.FacadePattern;

// Subsystems representing different API services
class AuthService {
    public void authenticate() {
        System.out.println("Authenticating user...");
    }
}

class PaymentService {
    public void processPayment() {
        System.out.println("Processing payment...");
    }
}

class ShippingService {
    public void shipOrder() {
        System.out.println("Shipping order...");
    }
}

// Client class using the API Gateway without the Facade pattern
public class APIServiceWithoutFacadePattern {
    public static void main(String[] args) {
        AuthService auth = new AuthService();
        PaymentService payment = new PaymentService();
        ShippingService shipper = new ShippingService();

        auth.authenticate();
        payment.processPayment();
        shipper.shipOrder();

        /**
         * Here the client is directly interacting with the microservices, which is not a good approach.
         */
    }
}
