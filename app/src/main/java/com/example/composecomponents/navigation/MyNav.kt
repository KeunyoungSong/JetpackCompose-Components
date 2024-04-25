package com.example.composecomponents.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyNav(
    modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = "Home", modifier = Modifier.padding(16.dp)) {
        composable("Home") {
            Column {
                Text(text = "Home")
                Button(onClick = {
                    navController.navigate("Office") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Office 로 이동")
                }
                Button(onClick = {
                    navController.navigate("Playground") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Playground 로 이동")
                }
                Button(onClick = {
                    navController.navigate("Home") {
                        launchSingleTop = true
                    }
                }) {
                    Text("Home 으로 이동")
                }
                Button(onClick = {
                    navController.navigate("Argument/song") {
                        launchSingleTop = true
                    }
                }) {
                    Text("Song 으로 이동")
                }
            }
        }
        composable("Office") {
            Column {
                Text(text = "Office")
                Button(onClick = {
                    navController.navigate("Home") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Home 으로 이동")
                }
                Button(onClick = {
                    navController.navigate("Playground") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Playground 로 이동")
                }
            }
        }

        composable("Playground") {
            Column {
                Text(text = "Playground")
                Button(onClick = {
                    navController.navigate("Home") {
                        popUpTo("Home") {
                            inclusive = true
                        }
                    }
                }) {
                    Text("Home 으로 이동")
                }
            }
        }

        composable("Argument/{userId}") {backStackEntry ->
            backStackEntry.arguments?.getString("userId").let { userId ->
                Text("userId: $userId")
            }
        }
    }
}