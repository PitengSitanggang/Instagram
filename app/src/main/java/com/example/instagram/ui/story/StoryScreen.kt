package com.example.instagram.ui.story

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.data.Story

@Composable
fun StorySection(
    myStory: Story,
    stories: List<Story>,
    onStoryClick: (Story) -> Unit,
    onAddStoryClick: () -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 8.dp)
    ){
        item{
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clickable { onAddStoryClick() }
            ){
                Box(
                    modifier = Modifier
                        .size(77.dp)
                        .clickable { onAddStoryClick() },
                    contentAlignment = Alignment.BottomEnd
                ){
                    Image(
                        painter = painterResource(id = myStory.imageRes),
                        contentDescription = "Cerita Anda",
                        modifier = Modifier
                            .size(77.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Box(
                        modifier = Modifier
                            .size(26.dp)
                            .align(Alignment.BottomEnd)
                            .offset(x = 4.dp, y = 4.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.background, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AddCircle,
                            contentDescription = "Add Story",
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Cerita Anda",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.White
                )
            }

        }

        items(stories) { story ->
            StoryItem(
                story = story,
                onClick = {onStoryClick(story)}
            )
        }
    }
}

@Composable
fun StoryItem(
    story: Story,
    onClick: () -> Unit,
    isMyStory: Boolean = false
) {
    val gradientBorder = Brush.linearGradient(
        colors = listOf(
            Color(0xFFFDD100), // kuning
            Color(0xFFF58529), // orange
            Color(0xFFDD2A7B), // pink-mgenta
            Color(0xFF8134AF), // purple
            Color(0xFF515BD4)  // blue-purple
        ),
        start = Offset(0f, 180f),
        end = Offset(270f, 0f)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .clickable { onClick() }
    ) {
        // Foto Story dengan border Instagram
        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .border(3.dp, gradientBorder, CircleShape)
                .padding(3.dp)
                .background(MaterialTheme.colorScheme.background, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = story.imageRes),
                contentDescription = story.username,
                modifier = Modifier
                    .size(77.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        // Nama Story di bawah foto
        Text(
            text = story.username,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .width(70.dp)
                .padding(top = 4.dp),
            textAlign = TextAlign.Center
        )
    }
}

