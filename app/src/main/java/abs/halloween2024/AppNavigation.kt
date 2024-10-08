package abs.halloween2024

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "halloween") {
        composable("halloween") { IchBinGeistina{navController.navigate("luigina")} }
        composable("luigina") { Luigina{navController.navigate("challenge")} }
        composable("challenge") { Aufgabe()}
//        composable("images") { Finale() }
    }
}