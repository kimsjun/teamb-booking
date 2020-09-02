package movieTicket.external;

import org.springframework.stereotype.Component;
@Component
public class PaymentFallback implements PaymentService{

    @Override
    public void makePayment(Payment payment) {
        System.out.println("hystrix!!!");
    }
}
