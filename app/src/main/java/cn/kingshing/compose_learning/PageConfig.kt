package cn.kingshing.compose_learning

import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.dp

/**
 *
 * Created by kingshingyeh on 2021/8/11.
 */
object PageConfig {

    val BOTTOM_MENU = listOf(
        Menu("行情", R.drawable.icon_nncircle),
        Menu("交易", R.drawable.icon_nncircle),
        Menu("资讯", R.drawable.icon_nncircle),
        Menu("牛牛圈", R.drawable.icon_nncircle),
        Menu("我的", R.drawable.icon_nncircle),
    )

    val paddingLeft = 16.dp
    val paddingRight = 16.dp
    val paddingTop = 0.dp
    val paddingBottom = 0.dp
}

data class Menu(
    val name: String,
    @DrawableRes val icon: Int
)