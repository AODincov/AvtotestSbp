package ru.resful.booker.APIClients.booker;

import retrofit2.Call;
import retrofit2.http.*;
import ru.resful.booker.models.BookingModel;

import java.util.List;

public interface BookingClient {


    //Не перезаписывает заголовки, при наличии дубликатов они будут отправлены
    //так же можно передавать заголовки в параметрах запроса retrofit2.http.Header
    @Headers({"Accept: application/json"})
    @GET("/booking")
    Call<List<BookingModel>> getBookingIDs();

    @GET("/booking")
    //пеередать null если параметр не отправляется
    Call<List<BookingModel>> getBookingIDsFilter(@Query("firstname") String firstname,
                                           @Query("lastname") String lastname);


    @PUT("/booking/{id}")
    @Headers({"Accept: application/json"})
    Call<BookingModel> editBook(@Path("id") int bookId, @Body BookingModel bookingModel);
}
