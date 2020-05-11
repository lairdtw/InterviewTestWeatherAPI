package tw.laird.interviewtestweatherapi;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tw.laird.interviewtestweatherapi.mainHome.AirAdapter;
import tw.laird.interviewtestweatherapi.utils.AppConfig;
import tw.laird.interviewtestweatherapi.webServices.AirData;
import tw.laird.interviewtestweatherapi.webServices.AirDataInterface;

public class MainActivity extends AppCompatActivity {

    //AppConfig
    AppConfig appConfig;

    /*RecyclerView*/
    RecyclerView rvAir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appConfig  = new AppConfig();

        initData();
        initView();
    }

    //Initial Data
    private void initData() {

        String location = "臺北市";

        //API - 36hr, Taipei
        getAirInfo(location);
    }

    //Initial View
    private void initView() {

        //RecyclerView
        rvAir = findViewById(R.id.rvAir);
        rvAir.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
    }

    //API - 36hr, Taipei
    private void getAirInfo(final String locationName) {
        /*Create handle for the RetrofitInstance interface*/
        AirDataInterface service = InterviewApp.getRetrofit().create(AirDataInterface.class);

        Call<AirData> call;

        call = service.getAirData(appConfig.authCode, locationName);

        call.enqueue(new Callback<AirData>() {
            @Override
            public void onResponse(@NotNull Call<AirData> call, @NotNull Response<AirData> response) {
                Log.d("onResponse", response.message());
                AirData airData = response.body();

                Log.e("RecordLog", Objects.requireNonNull(airData).getRecords().toString());

                generateAirDataList(Objects.requireNonNull(airData).getRecords());
            }

            @Override
            public void onFailure(@NotNull Call<AirData> call, @NotNull Throwable t) {
                //印出錯誤訊息
                Log.d("Error", Objects.requireNonNull(t.getMessage()));
                Toast.makeText(MainActivity.this, "伺服器錯誤！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateAirDataList(AirData.RecordsBean recordsBean) {
        AirAdapter airAdapter = new AirAdapter(MainActivity.this, recordsBean);
        rvAir.setAdapter(airAdapter);
        airAdapter.notifyDataSetChanged();
    }
}
