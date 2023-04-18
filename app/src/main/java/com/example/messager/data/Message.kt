package com.example.messager.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/*// Clase para representar un mensaje
data class Message(
    val sender: String = "",
    val recipient: String = "",
    val message: String = "",
    val timestamp: Long? = null
)*/
@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "sender") val sender: String,
    @ColumnInfo(name = "recipient") val recipient: String,
    @ColumnInfo(name = "message") val message: String,
    @ColumnInfo(name = "timestamp") val timestamp: Long?
)

