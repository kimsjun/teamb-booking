package movieTicket;

import movieTicket.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{

    @Autowired
    BookingRepository bookingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentCanceled_ChangeBookingStatus(@Payload PaymentCanceled paymentCanceled){


        if(paymentCanceled.isMe()) {

            System.out.println("##### listener CancelPayment : " + paymentCanceled.toJson());

            Long bookingId = paymentCanceled.getBookingId();
            System.out.println("##### unbooked.getBookingId : " + paymentCanceled.getBookingId());


            bookingRepository.findById(paymentCanceled.getBookingId()).ifPresent((booking -> {
                booking.setBookingStatus("cancel");
                bookingRepository.save(booking);
            }));
        }

    }


}
