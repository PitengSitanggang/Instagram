package com.example.instagram.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.instagram.R
import com.example.instagram.data.Story
import com.example.instagram.data.StoryRepository

class StoryViewModel(
    private val repository: StoryRepository = StoryRepository()
) : ViewModel() {
    val myStory = Story("You", R.drawable.my_profile)

    val stories = mutableStateListOf<Story>().apply {
        addAll(repository.getStories())
    }
}