package movieTicket;

import org.springframework.beans.BeanUtils;

import javax.persistence.*;

public class BookingVO {

    private Long bookingId;
    private Long customerId;
    private Long seatId;
    private Long quantity;
    private Double price;
    private String bookingStatus;

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
    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
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

    public Booking toEntity() {
        return Booking.builder().customerId(customerId)
                .seatId(seatId)
                .quantity(quantity)
                .price(price)
                .bookingStatus(bookingStatus)
                .build();
    }


}
