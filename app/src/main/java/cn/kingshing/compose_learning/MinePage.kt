package cn.kingshing.compose_learning

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cn.kingshing.compose_learning.ui.theme.FtTheme

/**
 *
 * Created by kingshingyeh on 2021/8/12.
 */
@Composable
fun MinePage(modifier: Modifier = Modifier) {
    Text(
        text = "hello mine page",
        color = FtTheme.colors.h1,
        modifier = modifier
            .fillMaxSize()
            .background(FtTheme.colors.block)
    )
}

@Composable
fun FtTopBar(title: String = "", onBack: (() -> Unit)? = null) {
    Box(
        Modifier
            .fillMaxWidth()
            .background(FtTheme.colors.background)
    ) {
        Row(
            Modifier
                .height(48.dp)
        ) {
            if (onBack != null) {
                Icon(
                    painterResource(R.drawable.ic_back),
                    null,
                    Modifier
                        .size(20.dp, 20.dp)
                        .clickable(onClick = onBack)
                        .align(Alignment.CenterVertically), tint = FtTheme.colors.h1
                )
            }
            Spacer(Modifier.weight(1f))
            val viewModel: NNViewModel = viewModel()
            Icon(
                painterResource(R.drawable.skin),
                "切换主题",
                Modifier
                    .clickable(onClick = {
                        viewModel.isSkinBlack = !viewModel.isSkinBlack
                    })
                    .align(Alignment.CenterVertically), tint = FtTheme.colors.h1
            )
        }
        Text(title, Modifier.align(Alignment.Center), color = FtTheme.colors.h1)
    }
}