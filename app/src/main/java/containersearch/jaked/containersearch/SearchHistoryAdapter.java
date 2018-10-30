package containersearch.jaked.containersearch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import containersearch.jaked.containersearch.R;

public class SearchHistoryAdapter extends ArrayAdapter<String[]> {

    private ArrayList<String[]> searchArray;

    private static final String CONTAINER_NUMBER = "CONTAINER_NUMBER";
    private static final String WEB_ADDRESS = "WEB_ADDRESS";
    private static final String SERVICE_NAME = "SERVICE_NAME";


    public SearchHistoryAdapter(Context context, ArrayList<String[]> search){
        super(context, 0, search);
        searchArray = search;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_search_history, parent, false);
        }

        String[] search = searchArray.get(position);

        final String containerNumber = search[0];
        final String serviceName = "Service: " +search[1];
         String date = search[2];
         System.out.println(date);
        String year = date.substring(24);
        String month = date.substring(4,7);
        String day = date.substring(8,10);
        String time = date.substring(11,19);
        final String formattedDate = month + " " + day + " " + year + " at " + time;

        ContainerNumber cn = new ContainerNumber(containerNumber);
        final String url = cn.getServiceMap().get(serviceName);

        TextView tvContainerNumber = convertView.findViewById(R.id.tvContainerNumber);
        TextView tvServiceName = convertView.findViewById(R.id.tvContainerService);
        TextView tvSearchDate = convertView.findViewById(R.id.tvSearchDate);

        tvContainerNumber.setText(containerNumber);
        tvServiceName.setText(serviceName);
        tvSearchDate.setText(formattedDate);



        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new WebTrackingFragment();
                Bundle bundle = new Bundle();
                bundle.putString(WEB_ADDRESS, url);
                bundle.putString(SERVICE_NAME, serviceName);
                bundle.putString(CONTAINER_NUMBER,containerNumber);
                fragment.setArguments(bundle);

                FragmentTransaction transaction = ((FragmentActivity)getContext()).getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return convertView;
    }
}
