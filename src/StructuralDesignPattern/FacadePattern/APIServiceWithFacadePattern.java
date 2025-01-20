package StructuralDesignPattern.FacadePattern;

// Subsystems representing different API services (same as before)
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

// Facade providing a simplified interface
// This facade is actually a APIGateway
class APIFacade {
    private AuthService authService;
    private PaymentService paymentService;
    private ShippingService shippingService;

    public APIFacade() {
        this.authService = new AuthService();
        this.paymentService = new PaymentService();
        this.shippingService = new ShippingService();
    }

    public void handleRequest() {
        authService.authenticate();
        paymentService.processPayment();
        shippingService.shipOrder();
    }
}

// Client class using the API Gateway with the Facade pattern
public class APIServiceWithFacadePattern {
    public static void main(String[] args) {
        APIFacade apiFacade = new APIFacade();
        apiFacade.handleRequest(); // Simplified call
    }
}
