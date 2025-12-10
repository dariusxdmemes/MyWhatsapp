package com.example.mywhatsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun PantallaPrincipal() {
    val context = LocalContext.current
    val datosStickyHeaders = getStickyData().groupBy { it.headerLabel }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        datosStickyHeaders.forEach { (headerLabel, items) ->
            stickyHeader {
                Row {
                    Text(
                        text = headerLabel,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(198, 198, 198, 255))
                            .padding(start = 5.dp)
                    )
                }
            }
            items(items) { dato ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(start = 10.dp)
                ) {
                    Image(
                        painter = painterResource(dato.rutaImagen),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                    )
                    Text(
                        text = dato.nombreUsuario,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun getStickyData(): List<StickyData> {
    return listOf(
        StickyData(
            stringResource(R.string.sticky_dpt_informatica),
            R.drawable.design,
            stringResource(R.string.jefe_dpt)
        ),
        StickyData(
            stringResource(R.string.sticky_dpt_informatica),
            R.drawable.drawing,
            stringResource(R.string.tutora_dam)
        ),
        StickyData(
            stringResource(R.string.sticky_dpt_informatica),
            R.drawable.crafts,
            stringResource(R.string.tutor_daw)
        ),
        StickyData(stringResource(R.string.sticky_dpt_informatica),
            R.drawable.ecology,
            stringResource(R.string.tutora_asix)
        ),
        StickyData(
            stringResource(R.string.sticky_com_propietarios),
            R.drawable.biology,
            stringResource(R.string.presidenta)
        ),
        StickyData(
            stringResource(R.string.sticky_com_propietarios),
            R.drawable.engineering,
            stringResource(R.string.secretaria)
        ),
        StickyData(
            stringResource(R.string.sticky_com_propietarios),
            R.drawable.culinary,
            stringResource(R.string.administrador)
        ),
        StickyData(
            stringResource(R.string.sticky_gym),
            R.drawable.business,
            stringResource(R.string.entrenadora)
        ),
        StickyData(
            stringResource(R.string.sticky_gym),
            R.drawable.automotive,
            stringResource(R.string.nutricionista)
        ),
        StickyData(
            stringResource(R.string.sticky_gym),
            R.drawable.architecture,
            stringResource(R.string.fisio)
        )
    )
}