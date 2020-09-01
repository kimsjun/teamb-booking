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

}
