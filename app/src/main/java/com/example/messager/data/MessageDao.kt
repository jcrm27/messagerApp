package com.example.messager.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MessageDao {
    @Query("SELECT * FROM messages WHERE sender = :sender AND recipient = :recipient ORDER BY timestamp DESC")
    fun getMessages(sender: String, recipient: String): LiveData<List<Message>>

    @Insert
    fun insert(message: Message)
}