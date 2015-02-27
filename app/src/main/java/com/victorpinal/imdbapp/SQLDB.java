package com.victorpinal.imdbapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Victor on 25/02/2015.
 */
public class SQLDB {

    private SQLDBUtil sqldbUtil;

    public SQLDB(Context ctx) {
        sqldbUtil = new SQLDBUtil(ctx);
    }

    public Cursor select(String sql) {
        return sqldbUtil.getReadableDatabase().rawQuery(sql, null);
    }

    public void execute(String sql) {
        sqldbUtil.getWritableDatabase().execSQL(sql);
    }

    public void close() {
        sqldbUtil.close();
    }

    private static class SQLDBUtil extends SQLiteOpenHelper {

        private static String CREATE_SQL = "CREATE TABLE [Film] (\n" +
                "\t[Rowid] integer NOT NULL PRIMARY KEY AUTOINCREMENT, \n" +
                "\t[Id] text NOT NULL, \n" +
                "\t[Name] text, \n" +
                "\t[Link] text, \n" +
                "\t[Rating] real, \n" +
                "\t[html] blob, \n" +
                "\t[fecha_alta] datetime, \n" +
                "\t[RatingCount] integer, \n" +
                "\t[Ruta] text\n" +
                ")\n" +
                "GO";

        public SQLDBUtil(Context context) {
            super(context, "PELICULAS", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS [Film]");
            db.execSQL(CREATE_SQL);
        }
    }

}
