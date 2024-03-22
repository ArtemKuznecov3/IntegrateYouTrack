package com.example.project.news_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project.news_screen.component.NewsCard
import com.example.project.news_screen.model.News

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(onBack: () -> Unit) {                                        //
    val notifications: List<News> = listOf(

        News(
            pers = "Шелкова А. П. - Зам. директора, НБ",
            title = "IX Международный молодежный фестиваль-конкурс поэзии и...",
            date = "09 января 2024, 13:59"
        ),  News(
            pers = "Шелкова А. П. - Зам. директора, НБ",
            title = "IX Международный молодежный фестиваль-конкурс поэзии и...",
            date = "09 января 2024, 13:59"
        ),  News(
            pers = "Шелкова А. П. - Зам. директора, НБ",
            title = "IX Международный молодежный фестиваль-конкурс поэзии и...",
            date = "09 января 2024, 13:59"
        ),  News(
            pers = "Шелкова А. П. - Зам. директора, НБ",
            title = "IX Международный молодежный фестиваль-конкурс поэзии и...",
            date = "09 января 2024, 13:59"
        ),
        News(
            pers = "Шелкова А. П. - Зам. директора, НБ",
            title = "IX Международный молодежный фестиваль-конкурс поэзии и...",
            date = "09 января 2024, 13:59"
        ),
        News(
            pers = "Муруев И. Е. - Начальник Управления, УМП",
            title = "IX Международный молодежный фестиваль-конкурс поэзии и...",
            date = "09 января 2024, 13:59"
        ),
        News(
            pers = "Муруев И. Е. - Начальник Управления, УМП",
            title = "IX Международный молодежный фестиваль-конкурс поэзии и...",
            date = "09 января 2024, 13:59"
        ),
        News(
            pers = "Муруев И. Е. - Начальник Управления, УМП",
            title = "IX Международный молодежный фестиваль-конкурс поэзии и...",
            date = "09 января 2024, 13:59"
        ),
        News(
            pers = "Муруев И. Е. - Начальник Управления, УМП",
            title = "IX Международный молодежный фестиваль-конкурс поэзии и...",
            date = "09 января 2024, 13:59"
        ),
        News(
            pers = "Муруев И. Е. - Начальник Управления, УМП",
            title = "IX Международный молодежный фестиваль-конкурс поэзии и...",
            date = "09 января 2024, 13:59"
        ),
        News(
            pers = "Муруев И. Е. - Начальник Управления, УМП",
            title = "IX Международный молодежный фестиваль-конкурс поэзии и...",
            date = "09 января 2024, 13:59"
        ),
        News(
            pers = "Муруев И. Е. - Начальник Управления, УМП",
            title = "IX Международный молодежный фестиваль-конкурс поэзии и...",
            date = "09 января 2024, 13:59"
        ),
        News(
            pers = "Муруев И. Е. - Начальник Управления, УМП",
            title = "IX Международный молодежный фестиваль-конкурс поэзии и...",
            date = "09 января 2024, 13:59"
        )
    )

    Scaffold(
        topBar = {



            TopAppBar(
                title = { Text(text = "Новости") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = ""
                        ) // топ бар с кнопкой перехода назад
                    }
                }
            )
        }
    )

    {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())                      //скрол
                .padding(16.dp)
        ) {
            notifications.forEach { notifications ->
                NewsCard(
                    title = notifications.title,
                    date = notifications.date,
                    pers = notifications.pers
                )

            }

        }
    }

}