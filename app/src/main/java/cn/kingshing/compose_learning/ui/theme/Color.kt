package cn.kingshing.compose_learning.ui.theme

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Red200 = Color(0xfff297a2)
val Red300 = Color(0xffea6d7e)
val Red700 = Color(0xffdd0d3c)
val Red800 = Color(0xffd00036)
val Red900 = Color(0xffc20029)
val Black = Color(0xFF000000)
val Black_95 = Color(0xF2000000)
val White = Color(0xFFFFFFFF)
val GrayWhite = Color(0xFFf6f6f6)
val GhostWhite = Color(0xFFE6E6FA)
val DimGray = Color(0xFF696969)
val Gray = Color(0xFF808080)
val DarkGray = Color(0xFFA9A9A9)
val LightGray = Color(0xFFD3D3D3)
val Silver = Color(0xFFC0C0C0)
val AquaBlue = Color(0xFF66FFE6)

fun skinWhite(
    h1: Color = Black,
    h2: Color = DimGray,
    h1Reverse: Color = White,
    h2Reverse: Color = Silver,
    background: Color = White,
    block: Color = GrayWhite,
): FtColors = FtColors(
    h1 = h1,
    h2 = h2,
    h1Reverse = h1Reverse,
    h2Reverse = h2Reverse,
    background = background,
    block = block,
)

fun skinBlack(
    h1: Color = White,
    h2: Color = Silver,
    h1Reverse: Color = Black,
    h2Reverse: Color = DimGray,
    background: Color = Black,
    block: Color = Black_95,
): FtColors = FtColors(
    h1 = h1,
    h2 = h2,
    h1Reverse = h1Reverse,
    h2Reverse = h2Reverse,
    background = background,
    block = block,
)


@Stable
class FtColors(
    h1: Color,
    h2: Color,
    h1Reverse: Color,
    h2Reverse: Color,
    background: Color,
    block: Color,
) {
    var h1 by mutableStateOf(h1, structuralEqualityPolicy())
        internal set
    var h2 by mutableStateOf(h2, structuralEqualityPolicy())
        internal set
    var h1Reverse by mutableStateOf(h1Reverse, structuralEqualityPolicy())
        internal set
    var h2Reverse by mutableStateOf(h2Reverse, structuralEqualityPolicy())
        internal set
    var background by mutableStateOf(background, structuralEqualityPolicy())
        internal set
    var block by mutableStateOf(block, structuralEqualityPolicy())
        internal set

    fun copy(
        h1: Color = this.h1,
        h2: Color = this.h2,
        h1Reverse: Color = this.h1Reverse,
        h2Reverse: Color = this.h2Reverse,
        background: Color = this.background,
        block: Color = this.block,
    ): FtColors = FtColors(
        h1 = h1,
        h2 = h2,
        h1Reverse = h1Reverse,
        h2Reverse = h2Reverse,
        background = background,
        block = block,
    )

    fun updateColorsFrom(other: FtColors) {
        this.h1 = other.h1
        this.h2 = other.h2
        this.h1Reverse = other.h1Reverse
        this.h2Reverse = other.h2Reverse
        this.background = other.background
        this.block = other.block
    }
}


internal val LocalFtColors = staticCompositionLocalOf { skinWhite() }