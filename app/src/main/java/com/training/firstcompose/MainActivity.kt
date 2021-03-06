package com.training.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.training.firstcompose.ui.theme.FirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    CardWithCheckable()
                }
            }
        }
    }
}

@Composable
fun CardWithCheckable() {
    var selecionada =  remember { mutableStateOf(false) }
    val imagem = if (selecionada.value) {
        painterResource(id = R.drawable.ic_check_filled)
    } else{
        painterResource(id = R.drawable.ic_check)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.frame__5_),
            contentDescription = "Prodct",
            modifier = Modifier
                .size(56.dp)
                .padding(end = 8.dp))

        Column() {
            Text(text = "Your Score")
            Text(text = "998 Points")
        }
        
        IconButton(onClick = {
            selecionada.value = !selecionada.value
        }) {
            Image(
                painter = imagem,
                contentDescription = "Checkable Icon",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardSelected() {
    FirstComposeTheme {
        CardWithCheckable()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CardUnselected() {
//    FirstComposeTheme {
//        CardWithCheckable()
//    }
//}