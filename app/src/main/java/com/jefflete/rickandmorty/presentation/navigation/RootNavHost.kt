package com.jefflete.rickandmorty.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jefflete.rickandmorty.presentation.ui.screen.characterdetailscreen.CharacterDetailScreen
import com.jefflete.rickandmorty.presentation.ui.screen.characterlistscreen.CharacterListScreen

@Composable
fun RootNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.CharacterList,
    ) {
        composable<Routes.CharacterList> {
            CharacterListScreen(onNavigateForward = { id ->
                navController.navigate(
                    Routes.CharacterDetail(
                        id = id
                    )
                )
            })
        }
        composable<Routes.CharacterDetail>(
        ) { backStackEntry ->
            val args: Routes.CharacterDetail = backStackEntry.toRoute()
            CharacterDetailScreen(args.id)
        }
//        composable<Routes.EpisodeList> { EpisodeListScreen() }
//        composable<Routes.EpisodeDetail>(
//            typeMap = mapOf(
//                typeOf<Routes.EpisodeDetail>() to CustomNavType(
//                    ScreenInfo::class.java, ScreenInfo.serializer()
//                )
//            ),
//        ) { EpisodeDetailScreen() }
//        composable<Routes.LocationList> { LocationListScreen() }
//        composable<Routes.LocationDetail>(
//            typeMap = mapOf(
//                typeOf<Routes.LocationDetail>() to CustomNavType(
//                    ScreenInfo::class.java, ScreenInfo.serializer()
//                )
//            ),
//        ) { LocationDetailScreen() }
    }
}