package movieTicket;

import movieTicket.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingListViewHandler {


    @Autowired
    private BookingListRepository bookingListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBooked_then_CREATE_1 (@Payload Booked booked) {
        try {
            if (booked.isMe()) {
                // view 객체 생성
                BookingList bookingList = new BookingList();
                // view 객체에 이벤트의 Value 를 set 함
                bookingList.setBookingId(booked.getBookingId());
                bookingList.setCustomerId(booked.getCustomerId());
                bookingList.setPrice(booked.getPrice());
                bookingList.setBookingStatus(booked.getOrderStatus());
                // view 레파지 토리에 save
                bookingListRepository.save(bookingList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenUnbooked_then_UPDATE_1(@Payload Unbooked unbooked) {
        try {
            if (unbooked.isMe()) {
                // view 객체 조회
                List<BookingList> bookingListList = bookingListRepository.findByBookingId(unbooked.getBookingId());
                for(BookingList bookingList : bookingListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookingList.setBookingStatus(unbooked.getOrderStatus());
                    // view 레파지 토리에 save
                    bookingListRepository.save(bookingList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookedSeat_then_UPDATE_2(@Payload BookedSeat bookedSeat) {
        try {
            if (bookedSeat.isMe()) {
                // view 객체 조회
                List<BookingList> bookingListList = bookingListRepository.findByBookingId(bookedSeat.getBookingId());
                for(BookingList bookingList : bookingListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookingList.setSeatStatus(bookedSeat.getSeatStatus());
                    // view 레파지 토리에 save
                    bookingListRepository.save(bookingList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenUnbookedSeat_then_UPDATE_3(@Payload UnbookedSeat unbookedSeat) {
        try {
            if (unbookedSeat.isMe()) {
                // view 객체 조회
                List<BookingList> bookingListList = bookingListRepository.findByBookingId(unbookedSeat.getBookingId());
                for(BookingList bookingList : bookingListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookingList.setSeatStatus(unbookedSeat.getSeatStatus());
                    // view 레파지 토리에 save
                    bookingListRepository.save(bookingList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentSucceed_then_UPDATE_4(@Payload PaymentSucceeded paymentSucceeded) {
        try {
            if (paymentSucceeded.isMe()) {
                // view 객체 조회
                List<BookingList> bookingListList = bookingListRepository.findByBookingId(paymentSucceeded.getBookingId());
                for(BookingList bookingList : bookingListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookingList.setPaymentStatus(paymentSucceeded.getPaymentStatus());
                    // view 레파지 토리에 save
                    bookingListRepository.save(bookingList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCanceled_then_UPDATE_5(@Payload PaymentCanceled paymentCanceled) {
        try {
            if (paymentCanceled.isMe()) {
                // view 객체 조회
                List<BookingList> bookingListList = bookingListRepository.findByBookingId(paymentCanceled.getBookingId());
                for(BookingList bookingList : bookingListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookingList.setPaymentStatus(paymentCanceled.getPaymentStatus());
                    // view 레파지 토리에 save
                    bookingListRepository.save(bookingList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenSentSms_then_UPDATE_6(@Payload SentSms sentSms) {
        try {
            if (sentSms.isMe()) {
                // view 객체 조회
                List<BookingList> bookingListList = bookingListRepository.findByBookingId(sentSms.getBookingId());
                for(BookingList bookingList : bookingListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookingList.setNotificationStatus(sentSms.getNotificationStatus());
                    // view 레파지 토리에 save
                    bookingListRepository.save(bookingList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}