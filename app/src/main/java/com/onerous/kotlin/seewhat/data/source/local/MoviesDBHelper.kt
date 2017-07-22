package com.onerous.kotlin.seewhat.data.source.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


/**
 * Created by rrr on 2017/7/20.
 */
class MoviesDBHelper(val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        val DATABASE_VERSION = 1

        val DATABASE_NAME = "Moives.db"

        private val TEXT_TYPE = " TEXT"

        private val DOUBLE_TYPE = " REAL"

        private val COMMA_SEP = ","

        private val SQL_CREATE_INTHEATERS_ENTRIES =
                "CREATE TABLE " + MoviesPersistenceContract.InTheatersEntity.TABLE_NAME + " (" +
                        MoviesPersistenceContract.InTheatersEntity._ID + TEXT_TYPE + " PRIMARY KEY," +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_MOVIE_ID + TEXT_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_NAME_DIRECTORS + TEXT_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_NAME_CASTS + TEXT_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_RATING + DOUBLE_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_GENRES + TEXT_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_YEARS + TEXT_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_IMAGE_URL_LARGE + TEXT_TYPE +COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_IMAGE_URL_MEDIUM + TEXT_TYPE +
                        " )"
        val top250_TABLE_NAME="top250"
        private val SQL_CREATE_TOP250_ENTRIES =
                "CREATE TABLE " + top250_TABLE_NAME + " (" +
                        MoviesPersistenceContract.InTheatersEntity._ID + TEXT_TYPE + " PRIMARY KEY," +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_MOVIE_ID + TEXT_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_NAME_DIRECTORS + TEXT_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_NAME_CASTS + TEXT_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_RATING + DOUBLE_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_GENRES + TEXT_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_YEARS + TEXT_TYPE + COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_IMAGE_URL_LARGE + TEXT_TYPE +COMMA_SEP +
                        MoviesPersistenceContract.InTheatersEntity.COLUMN_IMAGE_URL_MEDIUM + TEXT_TYPE +
                        " )"

    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_INTHEATERS_ENTRIES)
        db.execSQL(SQL_CREATE_TOP250_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Not required as at version 1
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Not required as at version 1
    }
}