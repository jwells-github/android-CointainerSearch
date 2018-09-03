package containersearch.jaked.containersearch;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContainerServiceAdapter extends ArrayAdapter<String> {


    public ArrayList<String> keyArray ;
    public ArrayList<String> valueArray ;


    public ContainerServiceAdapter(Context context, ArrayList<String> keyList, ArrayList<String> valueList){
        super(context,0,keyList);
        keyArray = keyList;
        valueArray = valueList;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_container_service, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);

        tvName.setText(keyArray.get(position));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicked " + position + " and " + keyArray.get(position));
            }
        });

        return convertView;


    }

}
