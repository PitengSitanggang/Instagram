package com.example.instagram.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.instagram.data.Post // Pastikan import data model Post Anda benar
import com.example.instagram.data.PostRepository // Pastikan import repository Anda benar

/**
 * Halaman utama untuk fitur Search/Explore.
 * Menampilkan SearchBar di atas dan SearchGrid di bawahnya.
 */
@Composable
fun SearchScreen() {
    // Mengambil daftar postingan dari repository lokal Anda.
    // `remember` digunakan agar data tidak diambil ulang setiap kali terjadi recomposition.
    val posts = remember { PostRepository.getPost() }

    // Menggunakan Surface sebagai latar belakang utama
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            // 1. Menampilkan Search Bar
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // 2. Menampilkan Grid Postingan
            SearchGrid(
                posts = posts,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

/**
 * Composable untuk Search Bar yang mirip dengan Instagram.
 */
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }

    TextField(
        value = query,
        onValueChange = { query = it },
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)), // Membuat sudut yang tumpul
        placeholder = { Text(text = "Search") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.LightGray.copy(alpha = 0.3f), // Warna latar belakang abu-abu transparan
            focusedIndicatorColor = Color.Transparent, // Menghilangkan garis bawah saat aktif
            unfocusedIndicatorColor = Color.Transparent // Menghilangkan garis bawah saat tidak aktif
        ),
        singleLine = true
    )
}

/**
 * Composable untuk menampilkan grid postingan 3 kolom.
 */
@Composable
fun SearchGrid(
    posts: List<Post>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // Membuat 3 kolom
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(2.dp), // Jarak horizontal antar item
        verticalArrangement = Arrangement.spacedBy(2.dp)     // Jarak vertikal antar item
    ) {
        // `items` akan mengulang setiap item di dalam daftar `posts`
        items(posts, key = { it.id }) { post ->
            Image(
                painter = painterResource(id = post.imageResList.first()),
                contentDescription = "Search Post Image",
                contentScale = ContentScale.Crop, // Penting agar gambar tidak gepeng
                modifier = Modifier.aspectRatio(1f) // Memastikan setiap item berbentuk persegi
            )
        }
    }
}