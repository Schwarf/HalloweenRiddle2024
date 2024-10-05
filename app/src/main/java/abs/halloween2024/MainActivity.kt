package abs.halloween2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import abs.halloween2024.ui.theme.HalloweenRiddle2024Theme
import android.graphics.PointF
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HalloweenRiddle2024Theme {
                Scaffold {
                    AppNavigation()
                }

            }
        }
    }
}

@Composable
fun IchBinGeistina(
    onButtonClick :() -> Unit
)
{
    Box(modifier = Modifier.fillMaxSize()) {
        // Background image setup
        Image(
            painter = painterResource(R.drawable.geistina),
            contentDescription = null, // Background image does not require a description
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.weight(1f)) // This adds flexible space between text and input
            Text(
                text = "Hallo Marta, \n " +
                        "ich bin Geistina. Kannst Du mir bei einer wichtigen Aufgabe " +
                        "helfen?",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 25.sp
                ),
            )
            Button(onClick = {onButtonClick()},
            ) {
                Text(text = "Ja!")
            }
        }
    }

}

@Composable
fun Luigina(
)
{
    Box(modifier = Modifier.fillMaxSize()) {
        // Background image setup
        Image(
            painter = painterResource(R.drawable.luigina),
            contentDescription = null, // Background image does not require a description
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Column(modifier = Modifier.padding(16.dp)) {
                GlowingText(text = "Das ist meine Schwester Luigina. Die gemeinen Geister haben sie gejagt." +
                        "Da es so viele Geister waren, hat sie sich wohl versteckt. " +
                        "Vielleicht finden wir eine Nachricht von ihr.", glowColor = Color.Green, textColor = Color.White)

//            Button(onClick = {onButtonClick()},
//            ) {
//                Text(text = "Ja!")
//            }
            Spacer(modifier = Modifier.weight(1f)) // This adds flexible space between text and input
        }
    }

}

@Composable
fun GlowingText(text: String, glowColor: Color, textColor: Color) {
    BasicText(
        text = text,
        style = TextStyle(
            color = textColor,
            fontSize = 24.sp,
            shadow = Shadow(
                color = glowColor,
                offset = Offset(0f, 0f),
                blurRadius = 16f
            )
        ),
        modifier = Modifier.graphicsLayer(alpha = 0.99f).drawWithContent {
            drawContent()
            withTransform({
                translate(left = 4f, top = 4f)
                scale(scaleX = 1.01f, scaleY = 1.01f)
            }) {
                this@drawWithContent.drawContent()
            }
        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HalloweenRiddle2024Theme {
        Greeting("Android")
    }
}