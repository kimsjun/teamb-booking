package movieTicket;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Booking_table")
public class Booking {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bookingId;
    private Long customerId;
    private String seatIdList;
    private Long quantity;
    private Double price;
    private String bookingStatus;

    @PostPersist
    public void onPostPersist(){
        Booked booked = new Booked();
        BeanUtils.copyProperties(this, booked);
        booked.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        movieTicket.external.Payment payment = new movieTicket.external.Payment();
        // mappings goes here
        BookingApplication.applicationContext.getBean(movieTicket.external.PaymentService.class)
            .makePayment(payment);


    }

    @PostUpdate
    public void onPostUpdate(){
        Unbooked unbooked = new Unbooked();
        BeanUtils.copyProperties(this, unbooked);
        unbooked.publishAfterCommit();


    }


    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getSeatIdList() {
        return seatIdList;
    }

    public void setSeatIdList(String seatIdList) {
        this.seatIdList = seatIdList;
    }
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }




}
