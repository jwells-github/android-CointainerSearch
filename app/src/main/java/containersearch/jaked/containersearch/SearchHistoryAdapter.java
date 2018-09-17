package containersearch.jaked.containersearch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import containersearch.jaked.containersearch.R;

public class SearchHistoryAdapter extends ArrayAdapter<String[]> {

    private ArrayList<String[]> searchArray;

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
        TextView tvContainerNumber = convertView.findViewById(R.id.tvContainerNumber);
        TextView tvServiceName = convertView.findViewById(R.id.tvContainerService);
        TextView tvSearchDate = convertView.findViewById(R.id.tvSearchDate);

        tvContainerNumber.setText(search[0]);
        tvServiceName.setText(search[1]);
        tvSearchDate.setText(search[2]);

        return convertView;
    }
}
