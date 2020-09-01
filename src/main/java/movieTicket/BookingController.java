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

  @PostMapping("/bookings")
  public Long test(@RequestBody BookingVO bookingVO) {
   return bookingService.bookSave(bookingVO);
  }


  @PutMapping("/bookings/{id}")
  public String test(@PathVariable("id") final Long id, @RequestBody BookingVO bookingVO) {
   bookingVO.setBookingId(id);
   bookingService.bookUpdate(bookingVO);
   return "Canceled";
  }


 }
