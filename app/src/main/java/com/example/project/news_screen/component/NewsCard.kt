package com.example.project.news_screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NewsCard(
    title: String,
    date: String,
    pers: String
) {
    Column(modifier = Modifier.padding(vertical = 10.dp)    ) {


        Text(
            text = pers,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp
        )
        Text(
            text = date,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp
        )
    }
}