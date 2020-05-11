package tw.laird.interviewtestweatherapi.mainHome;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import tw.laird.interviewtestweatherapi.mainDetail.DetailActivity;
import tw.laird.interviewtestweatherapi.R;
import tw.laird.interviewtestweatherapi.webServices.AirData;

public class AirAdapter extends RecyclerView.Adapter<AirAdapter.CustomViewHolder> {
    private Context context;
    private AirData.RecordsBean recordData;

    String strStartTime;
    String strEndTime;
    String strMinTemp;

    public AirAdapter(Context context, AirData.RecordsBean recordData) {
        this.context = context;
        this.recordData = recordData;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rv_item_card_air, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        AirData.RecordsBean recordsBean = recordData;

        AirData.RecordsBean.LocationBean.WeatherElementBean.TimeBean timeBeanList = recordsBean.getLocation().get(0).getWeatherElement().get(2).getTime().get(position);

        strStartTime = timeBeanList.getStartTime();
        strEndTime = timeBeanList.getEndTime();
        //Temperature
        strMinTemp = timeBeanList.getParameter().getParameterName() + timeBeanList.getParameter().getParameterUnit();

        /*SetText*/
        holder.tvStartTime.setText(timeBeanList.getStartTime());
        holder.tvEndTime.setText(timeBeanList.getEndTime());
        holder.tvMinTemp.setText(strMinTemp);

        /*View OnClickListener*/
        holder.cvAir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("inputStartTime", strStartTime);
                intent.putExtra("inputEndTime", strEndTime);
                intent.putExtra("inputMinTemp", strMinTemp);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d("MinTData.size()", String.valueOf(recordData.getLocation().get(0).getWeatherElement().get(2).getTime().size()));
        return recordData.getLocation().get(0).getWeatherElement().get(2).getTime().size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        CardView cvAir;
        TextView tvStartTime;
        TextView tvEndTime;
        TextView tvMinTemp;

        CustomViewHolder(View itemView) {
            super(itemView);

            cvAir = itemView.findViewById(R.id.cvAir);
            tvStartTime = itemView.findViewById(R.id.tvStartTime);
            tvEndTime = itemView.findViewById(R.id.tvEndTime);
            tvMinTemp = itemView.findViewById(R.id.tvMinTemp);
        }
    }
}
