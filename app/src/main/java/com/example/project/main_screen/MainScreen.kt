package com.example.project.main_screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.project.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(

    onNavigateToNewsScreen: () -> Unit, //лямда функции навигации
    onNavigateToNotification: () -> Unit
) {




    var showBottomSheet by remember { mutableStateOf(false) }  //функция для закрытие вкладки
    Scaffold(
         topBar = {
            TopAppBar(title = { Text(text = "Главная")},
                actions = {
                    IconButton(onClick = { onNavigateToNotification() }) {
                        Icon(Icons.Default.Notifications,contentDescription = null)
                    }
                })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {


            ExtendedFloatingActionButton(
                text = { Text("Новости") },
                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                onClick = {
                    showBottomSheet = true // здесь  мы фунцию закрытия делаем открытой
                }
            )

        }
    }

    if (showBottomSheet) {

        DetailBottomSheet(
            onClose = {
                showBottomSheet = false
            },
            onNavigateToNewsScreen = {
                onNavigateToNewsScreen()   //триггер с DetailBottomSheet см. 52
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailBottomSheet(
    onNavigateToNewsScreen: () -> Unit,   //лямда функции навигации
    onClose: () -> Unit // лямда функция
) {
    var isAllText by remember {
        mutableStateOf(false)
    }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)         // метод который открывает полностью вкладку
    val scope = rememberCoroutineScope()
    ModalBottomSheet(
        onDismissRequest = {
            onClose()                    //функция закрытия
        },
        sheetState = sheetState,
        modifier = Modifier.fillMaxSize()
    ) {
        // Sheet content
        Scaffold(
            bottomBar = {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Red
                    ),
                    modifier = Modifier

                        .padding(15.dp)
                        .size(width = 340.dp, height = 50.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .clickable {                           // кнопка
                                scope
                                    .launch {
                                        sheetState.hide()
                                    }
                                    .invokeOnCompletion {
                                        onClose()                        // сначала вызываем функцию закрытия см.106
                                        onNavigateToNewsScreen()         //переход на другую страницу   см. 87
                                    }                                    // навигация на другую страницу

                            }
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Перейти к новостям",
                            color = Color.White,
                            modifier = Modifier.padding(16.dp),
                        )
                    }
                }
            }

        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .verticalScroll(rememberScrollState()), //функция скролить
            ) {
                Text(text = "Закрыть", color = Color.Red, modifier = Modifier
                    .clickable {
                        scope.launch {
                            sheetState.hide()
                        }.invokeOnCompletion {
                            onClose()  //метод который закрывает окно
                        }
                    })
                Column {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Red)
                            .size(150.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {

                            Text(
                                text = "Раздел новости",
                                color = Color.White,
                                fontSize = 19.sp
                            )
                            Text(
                                text = "",
                                color = Color.White,
                                fontSize = 19.sp
                            )

                        }

                    }

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

                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.End
                        )
                        {
                            Row {

                                Text(
                                    text = "+37",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.photo_ball),

                                    contentDescription = "photo",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .size(20.dp)
                                        .clip(CircleShape)
                                )

                            }
                            Text(
                                text = "за каждые 100 рублей покупки ",
                                fontWeight = FontWeight.ExtraLight
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Text(text = "", fontWeight = FontWeight.Bold)
                        Text(text = "Подробнее", fontWeight = FontWeight.Bold)
                        Text(
                            text = "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est, qui dolorem ipsum, quia dolor sit, amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt, ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit, qui in ea voluptate velit esse, quam nihil molestiae consequatur, vel illum, qui dolorem eum fugiat, quo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus, qui blanditiis praesentium voluptatum deleniti atque corrupti, quos dolores et quas molestias excepturi sint, obcaecati cupiditate non provident, similique sunt in culpa, qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.",
                            fontWeight = FontWeight.Light,
                            maxLines = if (isAllText) Int.MAX_VALUE else 3,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (isAllText) "Скрыть" else "Показать еще",
                            Modifier.clickable { isAllText = !isAllText },
                            color = Color.Red
                        )



                    }
                }
            }
        }

    }
}



