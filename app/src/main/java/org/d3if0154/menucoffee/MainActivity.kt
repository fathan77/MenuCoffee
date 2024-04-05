package org.d3if0154.menucoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.d3if0154.menucoffee.screens.DetailScreen
import org.d3if0154.menucoffee.screens.MainScreen
import org.d3if0154.menucoffee.ui.theme.MenuCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuCoffeeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val imageId = arrayOf(
                        R.drawable.p1,
                        R.drawable.p2,
                        R.drawable.p3,
                        R.drawable.p4,
                        R.drawable.p5,
                        R.drawable.p6
                    )

                    val names = arrayOf(
                        "Iced Manuka Americano",
                        "Hot Manuka Americano",
                        "Iced Classic Latte",
                        "Iced Salted Caramel Mocha",
                        "Hot Espresso",
                        "Iced Cappuccino"
                    )

                    val ingredients = arrayOf(
                        "Americano dengan madu Manuka yang pas untuk jadi energy booster",
                        "Americano dengan madu Manuka yang pas untuk jadi energy booster",
                        "Perpaduan rasa espresso premium dengan saus krim spesial Fore",
                        "Perpaduan coklat, latte dari house blend Fore, dan gurihnya caramel",
                        "Ekstrak biji kopi Arabika murni tanpa campuran",
                        "Paduan espresso dengan susu sapi pilihan dan foam tebal di atasnya"
                    )
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen") {
                        composable(route = "MainScreen") {
                            MainScreen(imageId, names, ingredients, navController)
                        }
                        composable(route = "DetailScreen/{index}",
                            arguments = listOf(
                                navArgument(name = "index") {
                                    type = NavType.IntType
                                }
                            )
                        ) { index->
                            DetailScreen(
                                photos = imageId,
                                names = names,
                                ingredients = ingredients,
                                itemIndex = index.arguments?.getInt("index")
                            )
                        }
                    }
                }
            }
        }
    }
}
