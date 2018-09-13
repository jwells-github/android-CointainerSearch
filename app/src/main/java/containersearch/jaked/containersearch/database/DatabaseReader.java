package containersearch.jaked.containersearch.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


import containersearch.jaked.containersearch.database.SearchHistoryDatebaseSchema.SearchHistoryTable;

        // I think we want to return an array of arrays containing both the container number and the service

public class DatabaseReader {
    SQLiteDatabase mDatabase;


    public ArrayList<String[]> DatabaseReader(Context context){
        mDatabase = new SearchHistoryHelper(context).getWritableDatabase();
        ArrayList<String[]> albums = new ArrayList<String[]>();

        SearchHistoryCursorWrapper cursorWrapper = queryAlbums(null,null);

        try{
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                albums.add(cursorWrapper.getContainerSearch());
                cursorWrapper.moveToNext();
            }
        }
        finally {
            cursorWrapper.close();
        }
        return albums;
    }

    private SearchHistoryCursorWrapper queryAlbums(String whereClause,
                                                   String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                SearchHistoryTable.NAME,
                null, // columns - null selects allcolumns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );
        return new SearchHistoryCursorWrapper(cursor);
    }
}
