package com.example.project.notification.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)


@Composable
fun NotificationCard(
    title: String,
    date: String,
    isUnread: Boolean,
    onOpenDetail: () -> Unit
) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        onClick = {
            onOpenDetail()
        }
    ) { //круглая карта в которой через падинг мы меняем отступы//
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (isUnread) {
                        Box(
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .size(10.dp)
                                .background(Color.Red, CircleShape)
                        )
                    }

                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold
                    )
                }//фонтфеитболд жирный текст//
                Spacer(modifier = Modifier.size(4.dp)) //отступы между строк//
                Text(text = date, fontWeight = FontWeight.ExtraLight)
            }
            Box(modifier = Modifier.matchParentSize(), contentAlignment = Alignment.CenterEnd) {
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }
    }

}
