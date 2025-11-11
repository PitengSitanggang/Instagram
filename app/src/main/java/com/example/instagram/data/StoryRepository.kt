    package com.example.instagram.data

    import com.example.instagram.R

    class StoryRepository{
        fun getStories(): List<Story> {
            return listOf(
                Story("natanael", R.drawable.nell_trg)
            )
        }
    }