package com.example.e.permaguru;


import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by e on 10/5/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "plantData";

    // Plants table name
    private static final String TABLE_PLANTS = "plants";

    // Plants Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_NNAME = "nickname";

    //private static final String KEY_LIGHT = "light";
    //private static final String KEY_WATER = "water";
    //private static final String KEY_SOIL = "soil";
    //private static final String KEY_COLD = "cold";

    //private static final String KEY_SHADE = "shade";
    //private static final String KEY_S_PH = "soil_ph";
    //private static final String KEY_W_PH = "water_ph";
    //private static final String KEY_HEAT = "heat";

    //private static final String KEY_LAYER = "layer";
    //private static final String KEY_GUILD = "guild";
    //private static final String KEY_ZONE = "zone";

    //private static final String KEY_G_TIME = "germination_time";
    //private static final String KEY_ZONE = "";
    //private static final String KEY_ZONE = "zone";
    //private static final String KEY_ZONE = "zone";



    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PLANTS_TABLE = "CREATE TABLE " + TABLE_PLANTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_NNAME + " TEXT" + ")";
        db.execSQL(CREATE_PLANTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANTS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new plant
    void addPlant(Plant plant) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, plant.getName()); // Plant Name
        values.put(KEY_NNAME, plant.getNickName()); // Plant Phone

        // Inserting Row
        db.insert(TABLE_PLANTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single plant
    Plant getPlant(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PLANTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_NNAME }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Plant plant = new Plant(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return plant
        return plant;
    }

    // Getting All Plants
    public List<Plant> getAllPlants() {
        List<Plant> plantList = new ArrayList<Plant>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PLANTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Plant plant = new Plant();
                plant.setID(Integer.parseInt(cursor.getString(0)));
                plant.setName(cursor.getString(1));
                plant.setNickName(cursor.getString(2));
                // Adding plant to list
                plantList.add(plant);
            } while (cursor.moveToNext());
        }

        // return plant list
        return plantList;
    }

    // Updating single plant
    public int updatePlant(Plant plant) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, plant.getName());
        values.put(KEY_NNAME, plant.getNickName());

        // updating row
        return db.update(TABLE_PLANTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(plant.getID()) });
    }

    // Deleting single plant
    public void deletePlant(Plant plant) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PLANTS, KEY_ID + " = ?",
                new String[] { String.valueOf(plant.getID()) });
        db.close();
    }


    // Getting plants Count
    public int getPlantsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PLANTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}