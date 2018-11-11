package com.trustathanas.nearbyme.data.db


//@Database(entities = arrayOf(UserEntity::class), version = 1, exportSchema = true)
abstract class ApplicationDatabase /** : RoomDatabase()*/ {
    /** add your DAO here as abstract functions */
    abstract fun venueDao(): VenueDao
}