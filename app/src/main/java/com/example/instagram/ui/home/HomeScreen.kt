package com.example.instagram.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.instagram.R
import com.example.instagram.data.Story
import com.example.instagram.ui.common.HeaderInstagram
import com.example.instagram.ui.post.PostItem
import com.example.instagram.ui.post.PostViewModel
import com.example.instagram.ui.story.StorySection

@Composable
fun HomeScreen() {
    val postViewModel = PostViewModel()
    val myStory = Story("You", R.drawable.my_profile)
    val otherStories = listOf(
        Story("nell_trg", R.drawable.nell_trg),
        Story("mikaellsihombingg15", R.drawable.mikaellsihombingg15),
        Story("muhammadazizontowiro", R.drawable.muhammadazizontowiro),
        Story("ncoyyss", R.drawable.ncoyyss),
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            HeaderInstagram()
        }

        item {
            StorySection(
                myStory = myStory,
                stories = otherStories,
                onStoryClick = { /* TODO: buka story teman */ },
                onAddStoryClick = { /* TODO: tambahkan story */ }
            )
        }

        // Gunakan items dengan LIST, bukan COUNT
        items(
            items = postViewModel.posts,
            key = { post -> post.id } // optional: untuk performa lebih baik
        ) { post ->
            PostItem(post = post)
        }
    }
}