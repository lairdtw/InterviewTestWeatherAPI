package tw.laird.interviewtestweatherapi.mainDetail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import tw.laird.interviewtestweatherapi.R;

public class DetailActivity extends AppCompatActivity {

    //Intent Data
    String strStartTime;
    String strEndTime;
    String strMinTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initData();
        initView();

    }

    //Initial Data
    private void initData() {
        getIntentData();
    }

    //Receive Intent
    private void getIntentData() {

        Intent intentReceived = getIntent();

        strStartTime = intentReceived.getStringExtra("inputStartTime");
        strEndTime = intentReceived.getStringExtra("inputEndTime");
        strMinTemp = intentReceived.getStringExtra("inputMinTemp");
    }

    //Initial View
    private void initView() {
        TextView tvStartTime = findViewById(R.id.tvStartTime);
        TextView tvEndTime = findViewById(R.id.tvEndTime);
        TextView tvMinTemp = findViewById(R.id.tvMinTemp);

        tvStartTime.setText(strStartTime);
        tvEndTime.setText(strEndTime);
        tvMinTemp.setText(strMinTemp);
    }
}
