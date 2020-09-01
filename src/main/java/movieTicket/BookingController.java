package movieTicket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class BookingController {

  @Autowired
  BookingService bookingService;

  @PostMapping("/bookings/test")
  public Long test(@RequestBody Booking booking) {
   return bookingService.bookSave(booking);
  }



 }
