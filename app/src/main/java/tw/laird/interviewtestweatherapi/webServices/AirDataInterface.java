package tw.laird.interviewtestweatherapi.webServices;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//Weather OpenData
public interface AirDataInterface {

    //36hr, Taipei
    @GET("v1/rest/datastore/F-C0032-001")
    Call<AirData> getAirData(@Query("Authorization") String authorization, @Query("locationName") String locationName);

}
