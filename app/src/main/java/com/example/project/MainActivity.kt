package com.example.project

import  android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project.main_screen.MainScreen
import com.example.project.news_screen.NewsScreen
import com.example.project.notification.NotificationScreen
import com.example.project.notification.component.NotificationCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                AppContent()
            }

        }
    }
}


@Composable
fun AppContent() {
    val navController = rememberNavController()                                                 // сам контроллер

    NavHost(navController = navController,                                                     //навигация куда мы передаем контроллер
            startDestination = MainNavigationRoute.MAIN_SCREEN.name){           //функция чтоб при привязке приложения перекидывало на маин
        composable(MainNavigationRoute.MAIN_SCREEN.name){ // привязываем роут
            MainScreen(                                                                         // страница которую привязали
                onNavigateToNewsScreen = {
                    navController.navigate(MainNavigationRoute.NEWS_SCREEN.name)
                },
                onNavigateToNotification = {
                    navController.navigate(MainNavigationRoute.NOTIFICATION_SCREEN.name)
                }
            )
        }
        composable(MainNavigationRoute.NEWS_SCREEN.name){ // привязываем роут
            NewsScreen(                                                                        // страница которую привязали

                onBack = {
                    navController.popBackStack() // поп бэк переход назад
                }
            )
        }
        composable(MainNavigationRoute.NOTIFICATION_SCREEN.name){
            NotificationScreen(onBack = {
                navController.popBackStack()
            })
        }
    }
}

enum class MainNavigationRoute {                         // класс в котором мы перечесляем роут
    MAIN_SCREEN,
    NEWS_SCREEN,
    NOTIFICATION_SCREEN

}





















