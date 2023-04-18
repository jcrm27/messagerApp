package com.example.messager.data

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

// Clase para manejar la conexión con Firebase y la obtención y almacenamiento de los mensajes
class FirebaseManager (context: Context)  {
    private val db = Firebase.firestore
    val messageDao: RoomModule = RoomModule(context)
    val messageData = messageDao.database.messageDao()
    // Método para enviar un mensaje
    fun sendMessage(sender: String, recipient: String, message: String) {
        val chatRef = db.collection("chats").document("$sender-$recipient")
        val newMessage = hashMapOf(
            "sender" to sender,
            "recipient" to recipient,
            "message" to message,
            "timestamp" to FieldValue.serverTimestamp()
        )
        chatRef.collection("messages").add(newMessage)
    }

    // Método para recibir mensajes en tiempo real
    fun receiveMessages(sender: String, recipient: String, onMessagesReceived: (List<Message>) -> Unit) {
        val chatRef = db.collection("chats").document("$sender-$recipient")
        chatRef.collection("messages")
            .orderBy("timestamp", Query.Direction.ASCENDING)
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e)
                    return@addSnapshotListener
                }

                val messages = mutableListOf<Message>()
                for (doc in snapshot?.documents ?: emptyList()) {
                    val message = doc.toObject(Message::class.java)
                    if (message != null) {
                        messages.add(message)
                        val message = Message(sender = "user1", recipient = "user2", message = "Hola", timestamp = System.currentTimeMillis())
                        messageData.insert(message)
                    }
                }
                onMessagesReceived(messages)
            }
    }
}



