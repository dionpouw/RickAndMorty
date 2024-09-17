package com.jefflete.rickandmorty.presentation.ui.screen.characterlistscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.jefflete.rickandmorty.data.utils.Result
import com.jefflete.rickandmorty.domain.model.Character
import com.jefflete.rickandmorty.domain.model.Location
import com.jefflete.rickandmorty.domain.model.Origin
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(
    viewModel: CharacterListScreenViewModel = koinViewModel(),
    onNavigateForward: (id: String) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getCharacters()
    }
    val characters by viewModel.uiState.collectAsState()

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Characters") },
        )
    }, content = { paddingValues ->

        when (val state = characters) {
            is Result.Loading -> LoadingScreen(paddingValues)
            is Result.Success -> {
                CharacterListLayout(
                    paddingValues, onNavigateForward, character = state.data
                )
            }

            is Result.Error -> ErrorScreen(paddingValues, message = state.message)
        }
    })
}

@Composable
fun CharacterListLayout(
    paddingValues: PaddingValues,
    onNavigateForward: (id: String) -> Unit,
    character: List<Character>
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp),
        contentPadding = paddingValues,
    ) {
        items(character) { character ->
            CharacterCard(
                character = character,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                onNavigateForward = onNavigateForward
            )
        }
    }
}

@Composable
fun CharacterCard(
    modifier: Modifier = Modifier,
    character: Character,
    onNavigateForward: (id: String) -> Unit = {}
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .clickable { onNavigateForward(character.id.toString()) },
    ) {
        Column {
            SubcomposeAsyncImage(
                model = character.image, contentDescription = "Character Image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    ) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                }
            )
            Text(character.name, style = MaterialTheme.typography.titleLarge)
            Text(character.status, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun LoadingScreen(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun ErrorScreen(paddingValues: PaddingValues, message: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Text(
            text = "Error: $message", modifier = Modifier.align(Alignment.Center)
        )
    }
}


@Preview
@Composable
fun CharacterListScreenPreview() {
    CharacterCard(
        character = Character(
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            name = "Rick",
            status = "Alive",
            species = "Human",
            type = "",
            gender = "Male",
            origin = Origin(name = "Earth", url = ""),
            location = Location(name = "Earth", url = ""),
            episode = listOf("1", "2"),
            created = "",
            url = "",
            id = 1
        )
    )

}