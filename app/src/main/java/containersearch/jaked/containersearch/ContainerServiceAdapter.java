package containersearch.jaked.containersearch;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class ContainerServiceAdapter extends ArrayAdapter<String> implements Filterable {


    private ArrayList<String> filteredKeyArray;
    private ArrayList<String> filteredValueArray;

    private ArrayList<String> allKeyArray;
    private ArrayList<String> allValueArray;

    private ServiceFilter mServiceFilter;

    private Callbacks mCallbacks = (Callbacks) getContext();

    public interface Callbacks{

        void onServiceSelected(String serviceName, String url);
    }


    public ContainerServiceAdapter(Context context, ArrayList<String> keyList, ArrayList<String> valueList){
        super(context,0,keyList);
        allKeyArray = keyList;
        allValueArray = valueList;
        filteredKeyArray = keyList;
        filteredValueArray = valueList;

        getFilter();
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent){


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_container_service, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);

        tvName.setText(filteredKeyArray.get(position));

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*
                Uri webpage = Uri.parse(valueArray.get(position));
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if(intent.resolveActivity(getContext().getPackageManager()) != null){
                    getContext().startActivity(intent);
                }
*/
                mCallbacks.onServiceSelected(filteredKeyArray.get(position),filteredValueArray.get(position));


            }
        });

        return convertView;


    }

    @Override
    public int getCount() {
        return filteredValueArray.size();
    }

    @Override
    public Filter getFilter() {
        mServiceFilter = new ServiceFilter();
        return mServiceFilter;
    }


    private class ServiceFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            if(charSequence!= null && charSequence.length() > 0){
                ArrayList<String> tempKeyArray = new ArrayList<String>();
                ArrayList<String> tempValueArray = new ArrayList<String>();

                for(int i =0; i < allKeyArray.size(); i++){
                    if(allKeyArray.get(i).toLowerCase().contains(charSequence.toString().toLowerCase())){
                        tempKeyArray.add(allKeyArray.get(i));
                        tempValueArray.add(allValueArray.get(i));
                    }
                }
                filterResults.count = tempKeyArray.size();
                filterResults.values = tempKeyArray;
                filteredValueArray = tempValueArray;
            }
            else{
                filterResults.count = allKeyArray.size();
                filterResults.values = allKeyArray;
                filteredValueArray = allValueArray;
            }


            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            filteredKeyArray = (ArrayList<String>) filterResults.values;
            notifyDataSetChanged();
        }
    }
}
