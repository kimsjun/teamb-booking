package movieTicket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public Long bookSave(BookingVO bookingVO) {
        return bookingRepository.save(bookingVO.toEntity()).getBookingId();
    }

    public Long bookSaveTest(Booking booking) {
        return bookingRepository.save(booking).getBookingId();
    }


    public void bookUpdate(BookingVO bookingVO) {
        bookingRepository.findById(bookingVO.getBookingId()).ifPresent((booking -> {
            booking.setBookingStatus("cancel");
            bookingRepository.save(booking);
        }));
    }
}
