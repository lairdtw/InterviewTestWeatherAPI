package tw.laird.interviewtestweatherapi;

import android.app.Application;

import retrofit2.Retrofit;
import tw.laird.interviewtestweatherapi.webServices.RetrofitClientInstance;

public class InterviewApp extends Application {

    private static Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        //Retrofit
        setRetrofit();
    }

    private void setRetrofit() {
        retrofit = RetrofitClientInstance.getRetrofitInstance();
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
