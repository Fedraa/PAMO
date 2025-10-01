package com.example.avatar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.avatar.ui.theme.AvatarTheme

val Pink = Color(0xFFE91E63)
val LightPink = Color(0xFFFFDFE0)
val Orange = Color(0xFFE58200)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvatarTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AvatarApp", color = Color.White, fontWeight = FontWeight.Medium) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Pink
                )
            )
        }
    ) { paddingValues ->
        AvatarScreen(modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun AvatarScreen(modifier: Modifier = Modifier) {
    var displayBrow by remember { mutableStateOf(true) }
    var displayEye by remember { mutableStateOf(true) }
    var displayNose by remember { mutableStateOf(true) }
    var displayMouth by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LightPink),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(450.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.face_0004),
                contentDescription = "Base Face",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
            if (displayBrow) {
                Image(
                    painter = painterResource(id = R.drawable.face_0001), // Alis
                    contentDescription = "Brow",
                    modifier = Modifier
                        .fillMaxSize(0.55f)
                        .align(Alignment.Center)
                        .offset(y = -30.dp),
                    contentScale = ContentScale.Fit
                )
            }
            if (displayEye) {
                Image(
                    painter = painterResource(id = R.drawable.face_0003),
                    contentDescription = "Eye",
                    modifier = Modifier
                        .fillMaxSize(0.5f)
                        .align(Alignment.Center)
                        .offset(y = 5.dp),
                    contentScale = ContentScale.Fit
                )
            }
            if (displayNose) {
                Image(
                    painter = painterResource(id = R.drawable.face_0002),
                    contentDescription = "Nose",
                    modifier = Modifier
                        .fillMaxSize(0.13f)
                        .align(Alignment.Center)
                        .offset(y = 45.dp),
                    contentScale = ContentScale.Fit
                )
            }

            if (displayMouth) {
                Image(
                    painter = painterResource(id = R.drawable.face_0000),
                    contentDescription = "Mouth",
                    modifier = Modifier
                        .fillMaxSize(0.23f)
                        .align(Alignment.Center)
                        .offset(y = 95.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }

        Spacer(modifier = Modifier.height(64.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PartCheckbox(label = "Brow", checked = displayBrow, onCheckedChange = { displayBrow = it })
            PartCheckbox(label = "Eye", checked = displayEye, onCheckedChange = { displayEye = it })
            PartCheckbox(label = "Nose", checked = displayNose, onCheckedChange = { displayNose = it })
            PartCheckbox(label = "Mouth", checked = displayMouth, onCheckedChange = { displayMouth = it })
        }
    }
}

@Composable
fun PartCheckbox(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = Orange,
                uncheckedColor = Orange
            )
        )
        Text(text = label)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AvatarTheme {
        MainScreen()
    }
}