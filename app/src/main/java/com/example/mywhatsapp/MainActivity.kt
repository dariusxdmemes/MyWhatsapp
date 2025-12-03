package com.example.mywhatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.example.mywhatsapp.ui.theme.MyWhatsappTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyWhatsappTheme {
                var state by remember {
                    mutableIntStateOf(0)
                }
                val titulos = listOf(
                    stringResource(R.string.tab_first),
                    stringResource(R.string.tab_second),
                    stringResource(R.string.tab_third)
                )
                val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehavior.nestedScrollConnection),
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {/* Hacer algo */},
                            containerColor = MaterialTheme.colorScheme.secondary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ) {
                            Icon(
                                Icons.Default.Done,
                                contentDescription = "Icono FAB"
                            )
                        }
                    },
                    floatingActionButtonPosition = FabPosition.End,
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = MaterialTheme.colorScheme.onPrimary
                            ),
                            title = {
                                Text(
                                    text = stringResource(R.string.app_name)
                                )
                            },
                            actions = {
                                IconButton(
                                    onClick = { /* Hacer algo */ }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "Imagen derecha buscar",
                                        tint = MaterialTheme.colorScheme.onPrimary
                                    )
                                }
                                IconButton(
                                    onClick = { /* Hacer algo */ }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Share,
                                        contentDescription = "Imagen derecha share",
                                        tint = MaterialTheme.colorScheme.onPrimary
                                    )
                                }
                            },
                            scrollBehavior = scrollBehavior

                        )
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()

                    ) {
                        PrimaryTabRow(selectedTabIndex = state, containerColor = MaterialTheme.colorScheme.primary, contentColor = MaterialTheme.colorScheme.onPrimary) {
                            titulos.forEachIndexed { index, titulo ->
                                Tab(
                                    selected = state == index,
                                    onClick = { state = index },
                                    text = {
                                        Text(
                                            text = titulo, maxLines = 2, overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                )
                            }
                        }
                        when (state) {
                            0 -> PantallaPrincipal(modifier = Modifier.padding(innerPadding))
                            1 -> PantallaNovedades(modifier = Modifier.padding(innerPadding))
                            2 -> PantallaLlamadas(modifier = Modifier.padding(innerPadding))
                        }
                    }
                }
            }
        }
    }
}