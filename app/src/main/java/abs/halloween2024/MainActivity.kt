package abs.halloween2024

import abs.halloween2024.ui.theme.HalloweenRiddle2024Theme
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

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
    onButtonClick: () -> Unit
) {
    val context = LocalContext.current
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
                        "ich bin Geistina. Kannst Du mir und meiner Schwester helfen?",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 25.sp
                ),
            )
            Button(
                onClick = { onButtonClick() },
            ) {
                Text(text = "Ja!")
            }
            Button(
                onClick = {(context as? Activity)?.finishAffinity()},
            ) {
                Text(text = "Lieber nicht!")
            }

        }
    }

}

@Composable
fun Luigina(onButtonClick: () -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        // Background image setup
        Image(
            painter = painterResource(R.drawable.luigina),
            contentDescription = null, // Background image does not require a description
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Column(modifier = Modifier.padding(16.dp)) {
//                GlowingText(text = "Das ist meine Schwester Luigina. Die gemeinen Geister haben sie gejagt." +
//                        "Da es so viele Geister waren, hat sie sich wohl versteckt. " +
//                        "Vielleicht finden wir eine Nachricht von ihr.", glowColor = Color.Green, textColor = Color.White, alpha=0.99f)

            ColorChangingGlowingText(text = "Das ist meine Schwester Luigina. Die gemeinen Geister haben sie gejagt." +
                        "Da es so viele Geister waren, hat sie sich wohl versteckt. " +
                        "Vielleicht finden wir eine Nachricht von ihr.", textColor = Color.White)

//            PulsatingGlowingText(
//                text = "Das ist meine Schwester Luigina. Die gemeinen Geister haben sie gejagt." +
//                        "Da es so viele Geister waren, hat sie sich wohl versteckt. " +
//                        "Vielleicht finden wir eine Nachricht von ihr.",
//                glowColor = Color.Green,
//                textColor = Color.White
//            )
            Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { onButtonClick() },
                ) {
                    Text(text = "Weiter")
                }
            }
            Spacer(modifier = Modifier.weight(1f)) // This adds flexible space between text and input
        }
    }

}


@Composable
fun Aufgabe() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background image setup
        Image(
            painter = painterResource(R.drawable.garden),
            contentDescription = null, // Background image does not require a description
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        val Purple = Color(0xFF800080)
        Column(modifier = Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.weight(1f)) // This adds flexible space between text and input
            GlowingText(
                text = "Bevor sie verschwunden ist hat Luigina mir gesagt, dass ich ihr Smartphone finden muss. \n " +
                        "Dann hat sie mir noch das hier geschickt: \n" +
                        " 5 + 8 = ? \n" +
                        " 3 x 7 = ? \n" +
                        " 14 + 19 = ? \n",
                glowColor = Color.Red,
                textColor = Color.White,
                alpha = 0.8f
            )
        }
    }

}

@Composable
fun ColorChangingGlowingText(text: String, textColor: Color) {
    val alpha = remember { Animatable(0f) }
    val glowColor = remember { Animatable(Color.Green) }
    val colors = listOf(Color.Green, Color.Red, Color.Yellow, Color.Blue)
    var colorIndex = 0

    LaunchedEffect(key1 = "glow") {
        while (true) {
            alpha.animateTo(1f, animationSpec = TweenSpec(1000, easing = LinearEasing))
            delay(500)  // Keep the glow at full intensity for a bit
            alpha.animateTo(0f, animationSpec = TweenSpec(1000, easing = LinearEasing))
            glowColor.animateTo(
                colors[colorIndex],
                animationSpec = TweenSpec(1000, easing = LinearEasing)
            )
            colorIndex = (colorIndex + 1) % colors.size
        }
    }

    GlowingText(
        text = text,
        glowColor = glowColor.value,
        textColor = textColor,
        alpha = alpha.value
    )
}


@Composable
fun PulsatingGlowingText(text: String, glowColor: Color, textColor: Color) {
    val alpha = remember { Animatable(0f) }
    val animationSpec: AnimationSpec<Float> = InfiniteRepeatableSpec(
        animation = TweenSpec(durationMillis = 1500, easing = { it }),
        repeatMode = RepeatMode.Reverse
    )

    LaunchedEffect(key1 = true) {
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = animationSpec
        )
    }

    GlowingText(
        text = text,
        glowColor = glowColor,
        textColor = textColor,
        alpha = alpha.value
    )
}

@Composable
fun GlowingText(text: String, glowColor: Color, textColor: Color, alpha: Float) {
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
        modifier = Modifier
            .graphicsLayer(alpha = alpha)
            .drawWithContent {
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

