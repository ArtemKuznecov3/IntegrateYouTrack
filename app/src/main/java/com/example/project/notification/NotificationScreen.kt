package com.example.project.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.project.notification.component.NotificationCard
import com.example.project.notification.model.Notification

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(
    onBack:()-> Unit)
 {
    var presses by remember { mutableIntStateOf(0) }
    val notifications: List<Notification> = listOf(
        Notification(title = "Приглашаем пройти опрос", date = "01.02.2024", true),
        Notification(title = "Иследование", date = "02.05.2023", false),
        Notification(title = "Статья", date = "07.05.2021", isUnread = true)
    )
    var showBottomSheet by remember { mutableStateOf(false) }
     var selectedNotification: Notification? by remember {
         mutableStateOf(null)
     }
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 8.dp)
            ) {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        titleContentColor = MaterialTheme.colorScheme.onBackground,
                    ),
                    title = {
                        Text(text = "Уведомления")
                    },
                    navigationIcon = {
                        
                        Text(text = "Назад", color = Color.Red,
                            modifier = Modifier.clickable { onBack()
                                
                            })
                    },
                )
                Card(modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                    onClick = {}) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "31. 01.2024 - 1.03.2024", modifier = Modifier.padding(6.dp))
                        Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
                    }


                }

            }

        },
        containerColor = Color(0xFFF4F4F5)
    ) {
        Column(modifier = Modifier.padding(it)) {
            Row(modifier = Modifier.padding(16.dp)) {

                Text(text = "Уведомления", fontWeight = FontWeight.Bold)

            }
            notifications.forEach { notification ->
                NotificationCard(
                    title = notification.title,
                    date = notification.date,
                    isUnread = notification.isUnread,
                    onOpenDetail = {
                        selectedNotification = notification
                        showBottomSheet = true
                    }
                )
            }
        }
    }

    if (showBottomSheet) {
        DetailNotificationBottomSheet(
            onClose = {
                showBottomSheet = false
            },
            notification = selectedNotification ?: return
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailNotificationBottomSheet(
    notification: Notification,
    onClose: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)         // метод который открывает полностью вкладку
    val scope = rememberCoroutineScope()
    ModalBottomSheet(
        onDismissRequest = {
            onClose()                    //функция закрытия
        },
        sheetState = sheetState,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Text(text = notification.title)
        }
    }
}