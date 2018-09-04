package containersearch.jaked.containersearch;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContainerServiceAdapter extends ArrayAdapter<String> {


    private static final String WEB_ADDRESS = "CONTAINER_NUMBER";
    public ArrayList<String> keyArray ;
    public ArrayList<String> valueArray ;


    public ContainerServiceAdapter(Context context, ArrayList<String> keyList, ArrayList<String> valueList){
        super(context,0,keyList);
        keyArray = keyList;
        valueArray = valueList;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent){


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_container_service, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);

        tvName.setText(keyArray.get(position));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicked " + position + " and " + keyArray.get(position));

                Uri webpage = Uri.parse(valueArray.get(position));
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if(intent.resolveActivity(getContext().getPackageManager()) != null){
                    getContext().startActivity(intent);
                }
/*
                Fragment fragment = new WebTrackingFragment();
                Bundle bundle = new Bundle();
                bundle.putString(WEB_ADDRESS, valueArray.get(position));
                fragment.setArguments(bundle);
                FragmentTransaction transaction = ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                */
            }
        });

        return convertView;


    }

}
