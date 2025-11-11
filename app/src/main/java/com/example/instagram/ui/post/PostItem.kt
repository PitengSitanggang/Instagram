package com.example.instagram.ui.post

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.R
import androidx.compose.runtime.setValue
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.size
import androidx.compose.ui.draw.scale
import com.example.instagram.data.Post


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostItem(
    post: Post
){
    val pagerState = rememberPagerState(pageCount = {post.imageResList.size})
    var isSaved by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background)) {
        // Header (Profile + Username)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row {
                Image(
                    painter = painterResource(id = post.profileImageRes),
                    contentDescription = post.username,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(40.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = post.username,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
            }
            Icon(
                imageVector = Icons.Default.MoreVert,
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = "Menu"
            )
        }

        // Image Pager
        HorizontalPager(state = pagerState) { page ->
            Image(
                painter = painterResource(id = post.imageResList[page]),
                contentDescription = "Post Image ${page+1}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.Crop
            )
        }

        // Page Indicator di bawah image (hanya muncul jika ada lebih dari 1 gambar)
        if (post.imageResList.size > 1) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(post.imageResList.size) { index ->
                    Box(
                        modifier = Modifier
                            .size(if (index == pagerState.currentPage) 6.dp else 5.dp)
                            .clip(CircleShape)
                            .background(
                                if (index == pagerState.currentPage)
                                    Color(0xFF6076ff)
                                else
                                    MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f)
                            )
                    )
                    if (index != post.imageResList.size - 1) {
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                }
            }
        }

        // Action Buttons Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                // Like
                LikeButtonAnimated(likeCount = post.likeCount)

                // Comment
                Row(verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_comment),
                        contentDescription = "Comment",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.size(25.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${post.commentCount}",
                        fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                // Repost
                Row(verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_repost),
                        contentDescription = "Repost",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.size(25.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${post.repostCount}",
                        fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                // Share
                Row(verticalAlignment = Alignment.CenterVertically){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = "Share",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.size(26.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${post.shareCount}",
                        fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }


            }
            Icon(
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = "Save",
                modifier = Modifier
                    .size(23.dp),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }

        // Caption
        Text(
            text = post.username + " " + post.caption,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun LikeButtonAnimated(
    likeCount: Int,
    modifier: Modifier = Modifier
) {
    var isLiked by remember { mutableStateOf(false) }
    val scale = remember{ Animatable(1f) }

    LaunchedEffect(isLiked) {
        scale.snapTo(0f)
        scale.animateTo(1.2f, animationSpec = tween(350))
        scale.animateTo(1.0f, animationSpec = tween(150))
    }
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier){
        IconButton(
            onClick = {
                isLiked = !isLiked
            },
            modifier = Modifier.scale(scale.value)

        ) {
            val iconRes = if(isLiked) R.drawable.ic_like else R.drawable.ic_like_filled
            val tintColor = if(!isLiked) Color(0xFFfb303c) else MaterialTheme.colorScheme.onBackground

            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = "Like",
                tint = tintColor,
                modifier = Modifier.size(28.dp)
            )

        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = likeCount.toString(),
            fontWeight = FontWeight.Medium,
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}