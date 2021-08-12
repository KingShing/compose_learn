package cn.kingshing.compose_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.AndroidUiDispatcher
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.kingshing.compose_learning.ui.theme.Compose_learningTheme
import cn.kingshing.compose_learning.ui.theme.FtTheme
import cn.kingshing.compose_learning.widget.HorizontalPager
import cn.kingshing.compose_learning.widget.PagerState
import cn.kingshing.compose_learning.widget.pagerTabIndicatorOffset
import cn.kingshing.compose_learning.widget.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: NNViewModel by viewModels()

        setContent {
            Compose_learningTheme(isSkinBlack = viewModel.isSkinBlack) {
                Surface {
                    HomePage()
                }
            }
        }
    }
}

@Composable
fun HomePage() {
    val pagerState = rememberPagerState(pageCount = 5)
    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        // 内容页
        ContentPage(
            pagerState = pagerState,
            modifier = Modifier
                .background(FtTheme.colors.block)
        )
        // 底部菜单
        BottomMenu(
            pagerState = pagerState,
            modifier = Modifier
                .background(FtTheme.colors.background),
        )
    }
}

@Composable
fun ContentPage(pagerState: PagerState, modifier: Modifier = Modifier) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier.background(FtTheme.colors.block)

    ) { page ->
        //  page content

        Scaffold(
            topBar = { FtTopBar(title = PageConfig.BOTTOM_MENU[page].name, onBack = {}) }
        ) {

            if (page == 4) {
                MinePage()
            } else {
                Text(
                    modifier = modifier
                        .fillMaxSize()
                        .background(FtTheme.colors.block),
                    color = FtTheme.colors.h1,
                    text = "Page: ${page + 1}",
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}

@Composable
fun BottomMenu(pagerState: PagerState, modifier: Modifier = Modifier) {

    TabRow(
        modifier = modifier.wrapContentSize(),
        backgroundColor = FtTheme.colors.background,
        contentColor = FtTheme.colors.h1,
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(Modifier.pagerTabIndicatorOffset(pagerState, tabPositions))
        }
    ) {

        PageConfig.BOTTOM_MENU.forEachIndexed { index, menu ->

            Tab(
                modifier = modifier,
                text = { Text(text = menu.name, fontSize = 12.sp) },
                icon = { Image(bitmap = ImageBitmap.imageResource(menu.icon), "") },
                selected = pagerState.currentPage == index,
                onClick = {
                    CoroutineScope(AndroidUiDispatcher.Main).launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}