package com.muhtarkhan.hw.Cart.Db.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.muhtarkhan.hw.Cart.Db.Dao.CartDao
import com.muhtarkhan.hw.Cart.Db.Entity.CartItem

@Database(entities = [CartItem::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun cartDao(): CartDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "cart_database"
                )   .allowMainThreadQueries()
                    .build().also { INSTANCE = it }
            }
        }
    }
}