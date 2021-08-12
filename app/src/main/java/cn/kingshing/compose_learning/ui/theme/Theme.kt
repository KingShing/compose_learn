package cn.kingshing.compose_learning.ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

private val ft_skinWhite = skinWhite()
private val ft_skinBlack = skinBlack()

@Composable
fun Compose_learningTheme(isSkinBlack: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (isSkinBlack) {
        ft_skinBlack
    } else {
        ft_skinWhite
    }

    FtTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun FtTheme(
    colors: FtColors,
    typography: Typography = MaterialTheme.typography,
    shapes: Shapes = MaterialTheme.shapes,
    content: @Composable () -> Unit
) {
    val rememberedColors = remember {
        colors.copy()
    }.apply { updateColorsFrom(colors) }
    val rippleIndication = rememberRipple()
    CompositionLocalProvider(
        LocalFtColors provides rememberedColors,
        LocalContentAlpha provides ContentAlpha.high,
        LocalIndication provides rippleIndication,
    ) {
        ProvideTextStyle(value = typography.body1, content = content)
    }
}


object FtTheme {
    val colors: FtColors
        @Composable
        @ReadOnlyComposable
        get() = LocalFtColors.current
}
