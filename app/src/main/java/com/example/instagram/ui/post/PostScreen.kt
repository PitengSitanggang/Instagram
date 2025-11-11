package com.example.instagram.ui.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.instagram.data.Post

@Composable
fun PostScreen(posts: List<Post>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(bottom = 8.dp),
//        contentPadding = PaddingValues(bottom = 60.dp)
    ) {
        items(posts) { post ->
            PostItem(post = post)
        }
    }
}