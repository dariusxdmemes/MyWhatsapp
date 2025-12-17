package com.example.mywhatsapp

import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun PantallaNovedades() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PlayPauseAnimado()
    }
}

@Composable
fun PlayPauseAnimado() {
    var isPlaying by remember { mutableStateOf(false) }
    val imagen = AnimatedImageVector.animatedVectorResource(R.drawable.avd_pause_to_play)
    val painter = rememberAnimatedVectorPainter(
        animatedImageVector = imagen,
        atEnd = isPlaying
    )

    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(90.dp)
            .clickable {
                isPlaying = !isPlaying
            }
    )
}