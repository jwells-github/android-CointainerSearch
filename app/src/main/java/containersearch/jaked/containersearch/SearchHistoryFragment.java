package containersearch.jaked.containersearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import containersearch.jaked.containersearch.database.DatabaseReader;

public class SearchHistoryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search_history,container, false);
        ListView lvSearchHsitory = v.findViewById(R.id.lvSearchHistory);
        DatabaseReader databaseReader = new DatabaseReader();

        ArrayList<String[]> historyArray = databaseReader.DatabaseReader(getContext());
        Collections.reverse(historyArray);
        SearchHistoryAdapter adapter = new SearchHistoryAdapter(getContext(), historyArray);
        lvSearchHsitory.setAdapter(adapter);


        return v;
    }
}
