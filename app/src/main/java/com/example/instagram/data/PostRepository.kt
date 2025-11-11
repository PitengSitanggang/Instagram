package com.example.instagram.data

import com.example.instagram.R

object PostRepository{
    fun getPost(): List<Post>{
        return listOf(
                Post(
                    id = 1,
                    username = "ncoyyss",
                    profileImageRes = R.drawable.ncoyyss,
                    imageResList = listOf(
                        R.drawable.post_1,
                        R.drawable.post_2,
                        R.drawable.post_3,
                        R.drawable.post_4
                    ),
                    caption = "\uD83D\uDD25\uD83D\uDCA5\uD83D\uDE4C",
                    likeCount = 37,
                    commentCount = 4,
                    repostCount = 0,
                    shareCount = 5
                ),
                Post(
                    id = 2,
                    username = "byoncombat",
                    profileImageRes = R.drawable.byoncombat,
                    imageResList = listOf(
                        R.drawable.byon_post_1
                    ),
                    caption = "‼\uFE0F\uD83D\uDEA8OFFICIAL MAIN FIGHT POSTER \uD83D\uDEA8‼\uFE0F\n" +
                            "\uD83C\uDDEE\uD83C\uDDE9 RONAL SIAHAAN VS PUTRA ABDULLAH \uD83C\uDDF2\uD83C\uDDFE",
                    likeCount = 27300,
                    commentCount = 327,
                    repostCount = 158,
                    shareCount = 89
                )
        )
    }
}