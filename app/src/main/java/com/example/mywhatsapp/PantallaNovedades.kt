package com.example.mywhatsapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun PantallaNovedades(modifier: Modifier) {
    Text(
        text = stringResource(R.string.tab_second)+" works!"
    )
}