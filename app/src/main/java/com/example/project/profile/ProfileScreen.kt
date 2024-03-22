package com.example.project.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.project.R

@Composable
fun ProfileScreen() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.photo),

            contentDescription = "photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(5.dp)
                .size(65.dp)
                .clip(CircleShape)
        )


    }
}