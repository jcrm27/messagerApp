package com.example.messager.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.messager.data.User


@Composable
fun UserList(users: List<User>, onClick: (User) -> Unit) {
    LazyColumn {
        items(users) { user ->
            UserListItem(user = user, onClick = onClick)
            Divider()
        }
    }
}

@Composable
fun UserListItem(user: User, onClick: (User) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onClick(user) })
            .padding(16.dp)
    ) {
        Text(
            text = user.name,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.weight(1f)
        )
        // You can add additional information about the user here, such as their profile picture or online status
    }
}