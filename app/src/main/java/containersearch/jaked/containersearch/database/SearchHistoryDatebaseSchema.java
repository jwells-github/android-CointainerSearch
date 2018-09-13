package containersearch.jaked.containersearch.database;

// Defines the cloumns of the SQLite database
public class SearchHistoryDatebaseSchema {

    public static final class SearchHistoryTable {
        public static final String NAME = "searchHistory";

        public static final class Cols{
            public static final String CONTAINER_NUMBER = "containerNumber";
            public static final String SERVICE = "service";
            public static final String DATE = "date";
        }
    }
}
