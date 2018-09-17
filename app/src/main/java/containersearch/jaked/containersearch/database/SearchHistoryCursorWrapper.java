package containersearch.jaked.containersearch.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import containersearch.jaked.containersearch.database.SearchHistoryDatebaseSchema.SearchHistoryTable;

public class SearchHistoryCursorWrapper extends CursorWrapper {

    public SearchHistoryCursorWrapper(Cursor cursor){
        super(cursor);
    }


    public String[] getContainerSearch(){
        String containerNumber = getString(getColumnIndex(SearchHistoryTable.Cols.CONTAINER_NUMBER));
        String searchServuce = getString(getColumnIndex(SearchHistoryTable.Cols.SERVICE));
        String searchDate = getString(getColumnIndex(SearchHistoryTable.Cols.DATE));

        return new String[]{containerNumber,searchServuce,searchDate};
    }
}
