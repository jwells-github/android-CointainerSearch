package containersearch.jaked.containersearch.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import containersearch.jaked.containersearch.database.SearchHistoryDatebaseSchema.SearchHistoryTable;

public class SearchHistoryHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "SearchHistoryDatabase.db";

    public SearchHistoryHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + SearchHistoryTable.NAME +
                "(" + " _id integer primary key autoincrement,"
                    + SearchHistoryTable.Cols.CONTAINER_NUMBER + ", "
                    + SearchHistoryTable.Cols.SERVICE + ", "
                    + SearchHistoryTable.Cols.DATE  + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
