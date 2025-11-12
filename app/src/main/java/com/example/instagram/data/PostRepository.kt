package com.example.instagram.data

import com.example.instagram.R

object PostRepository {
    // Daftar postingan dummy baru menggunakan aset Anda
    private val posts = listOf(
        Post(
            id = 1,
            username = "ncoyyss",
            profileImageRes = R.drawable.ncoyyss,
            imageResList = listOf(
                R.drawable.post_1,
                R.drawable.post_2,
            ),
            caption = "Menikmati pemandangan hari ini.",
            likeCount = 1337,
            commentCount = 120,
            repostCount = 15,
            shareCount = 42
        ),
        Post(
            id = 2,
            username = "byoncombat",
            profileImageRes = R.drawable.byoncombat,
            imageResList = listOf(
                R.drawable.byon_post_1
            ),
            caption = "Siap untuk pertarungan berikutnya! #ByonCombat",
            likeCount = 27300,
            commentCount = 327,
            repostCount = 158,
            shareCount = 89
        ),
        Post(
            id = 3,
            username = "mikaellsihombingg15",
            profileImageRes = R.drawable.mikaellsihombingg15,
            imageResList = listOf(R.drawable.post_3),
            caption = "Waktu santai di akhir pekan.",
            likeCount = 854,
            commentCount = 98,
            repostCount = 7,
            shareCount = 22
        ),
        Post(
            id = 4,
            username = "muhammadaziz", // Nama disingkat agar mudah
            profileImageRes = R.drawable.muhammadazizontowiro,
            imageResList = listOf(R.drawable.post_4),
            caption = "Perjalanan baru, semangat baru.",
            likeCount = 2024,
            commentCount = 350,
            repostCount = 25,
            shareCount = 60
        ),
        Post(
            id = 5,
            username = "nell_trg",
            profileImageRes = R.drawable.nell_trg,
            imageResList = listOf(R.drawable.post_1, R.drawable.post_3),
            caption = "Kombinasi warna yang sempurna.",
            likeCount = 998,
            commentCount = 112,
            repostCount = 10,
            shareCount = 31
        ),
        Post(
            id = 6,
            username = "Attar34", // Menggunakan my_profile sebagai user utama
            profileImageRes = R.drawable.my_profile,
            imageResList = listOf(R.drawable.post_2),
            caption = "Kode hari ini disponsori oleh kopi ☕",
            likeCount = 500,
            commentCount = 50,
            repostCount = 5,
            shareCount = 15
        ),
        Post(
            id = 7,
            username = "ncoyyss",
            profileImageRes = R.drawable.ncoyyss,
            imageResList = listOf(R.drawable.post_3, R.drawable.post_4),
            caption = "Melihat kembali momen-momen indah.",
            likeCount = 1500,
            commentCount = 210,
            repostCount = 20,
            shareCount = 55
        ),
        Post(
            id = 8,
            username = "mikaellsihombingg15",
            profileImageRes = R.drawable.mikaellsihombingg15,
            imageResList = listOf(R.drawable.post_2),
            caption = "Seni dalam kesederhanaan.",
            likeCount = 780,
            commentCount = 80,
            repostCount = 4,
            shareCount = 18
        ),
        Post(
            id = 9,
            username = "nell_trg",
            profileImageRes = R.drawable.nell_trg,
            imageResList = listOf(R.drawable.post_4),
            caption = "Cahaya sore.",
            likeCount = 1100,
            commentCount = 140,
            repostCount = 12,
            shareCount = 35
        ),
        Post(
            id = 10,
            username = "muhammadaziz",
            profileImageRes = R.drawable.muhammadazizontowiro,
            imageResList = listOf(R.drawable.post_1),
            caption = "Memulai dari awal lagi.",
            likeCount = 1800,
            commentCount = 280,
            repostCount = 22,
            shareCount = 50
        )
    )

    fun getPost(): List<Post> {
        return posts
    }

    fun getPostById(id: Int): Post? {
        return posts.find { it.id == id }
    }
}