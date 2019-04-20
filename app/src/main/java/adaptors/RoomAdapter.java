package adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.hh.jikbangexample.R;

import java.util.List;

import datas.Rooms;

public class RoomAdapter extends ArrayAdapter<Rooms> {
    Context mContext;
    List<Rooms> mList;
    LayoutInflater inf;

    public RoomAdapter(Context context, List<Rooms> list){

        super(context, R.layout.room_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }



    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null){
            row = inf.inflate(R.layout.room_list_item, null);

        }


        Rooms roomData = mList.get(position);
        

        TextView paymentTxt = row.findViewById(R.id.paymentTxt);
        TextView locationAndFloorTxt = row.findViewById(R.id.locationAndFloorTxt);
        TextView descriptionTxt = row.findViewById(R.id.descriptionTxt);

        paymentTxt.setText(String.format("%d %d", roomData.deposit, roomData.month_pay));
        locationAndFloorTxt.setText(String.format("%s, %d층", roomData.location, roomData.floor));
        descriptionTxt.setText(String.format("%s", roomData.description));

        return row;
    }



}

