package example.pbuskell.com.teamjerseyproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by student on 30/05/2016.
 */
public class JerseyDatabase extends SQLiteOpenHelper {
    private final static String DB_NAME = "username";
    private final static int DB_VERSION = 1;
    public JerseyDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("CREATE TABLE JERSEYINFO(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "USERNAME TEXT, " +
                "USER_NUM INTEGER, " +
                "TEAMNAME TEXT);");
    }

    public void insertElement(SQLiteDatabase db, ContentValues newContent){

        db.insert("JERSEYINFO", null, newContent);

    }

    public int alterElement(SQLiteDatabase db, ContentValues alteredContent, String where,
                            String[] whereArgs){

        return db.update("JERSEYINFO", alteredContent, where, whereArgs);

    }

    public int deleteElement(SQLiteDatabase db, String where, String[] whereArgs){

        return db.delete("JERSEYINFO", where, whereArgs);

    }
}