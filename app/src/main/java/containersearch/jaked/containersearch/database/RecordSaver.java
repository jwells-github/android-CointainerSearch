package containersearch.jaked.containersearch.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;
import java.util.Calendar;

import containersearch.jaked.containersearch.database.SearchHistoryDatebaseSchema.SearchHistoryTable;

// Handles saving new and updates albums into the database
// Also hnadles the removal of albums from the database
public class RecordSaver {

    // Add a new row to the database
    public void addRecord(String containerNumber,String serviceName, Context context){
        SQLiteDatabase database = new SearchHistoryHelper(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SearchHistoryTable.Cols.CONTAINER_NUMBER, containerNumber);
        values.put(SearchHistoryTable.Cols.SERVICE, serviceName);
        values.put(SearchHistoryTable.Cols.DATE, Calendar.getInstance().getTime().toString());
        database.insert(SearchHistoryTable.NAME, null, values);
    }

    public void clearDatabase(Context context){
        SQLiteDatabase database = new SearchHistoryHelper(context).getWritableDatabase();
        database.delete(SearchHistoryTable.NAME,null,null);
    }


}
