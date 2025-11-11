package com.example.instagram.ui.post

import androidx.lifecycle.ViewModel
import com.example.instagram.data.Post
import com.example.instagram.data.PostRepository

class PostViewModel : ViewModel() {
    val posts: List<Post> = PostRepository.getPost()
}