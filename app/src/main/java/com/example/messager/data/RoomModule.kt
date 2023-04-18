package com.example.messager.data

import android.content.Context
import androidx.room.Room

class RoomModule(context: Context) {
    val database = Room.databaseBuilder(context, MessageDatabase::class.java, "messagedatabase")
        .build()

}