package cn.kingshing.compose_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AndroidUiDispatcher
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.kingshing.compose_learning.ui.theme.Compose_learningTheme
import cn.kingshing.compose_learning.widget.HorizontalPager
import cn.kingshing.compose_learning.widget.PagerState
import cn.kingshing.compose_learning.widget.pagerTabIndicatorOffset
import cn.kingshing.compose_learning.widget.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Compose_learningTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomePage()
                }
            }
        }
    }
}

@Composable
fun HomePage() {
    val pagerState = rememberPagerState(pageCount = 5)
    Box(contentAlignment = Alignment.BottomCenter,modifier = Modifier.background(Color.Black)) {
        ContentPage(pagerState)
        BottomMenu(
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 9.dp),
            pagerState = pagerState
        )
    }
}

@Composable
fun ContentPage(pagerState: PagerState, modifier: Modifier = Modifier) {
    HorizontalPager(
        state = pagerState,
        modifier.fillMaxSize()
    ) { page ->
        //  page content
        Text(
            modifier = modifier.fillMaxSize(),
            text = "Page: ${page + 1}",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun BottomMenu(pagerState: PagerState, modifier: Modifier = Modifier) {
    TabRow(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        contentColor= Color.Green,
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(Modifier.pagerTabIndicatorOffset(pagerState, tabPositions))
        }
    ) {

        Tab(
            modifier = modifier,
            text = { Text(text = "行情", fontSize = 12.sp) },
            selected = pagerState.currentPage == 0,
            onClick = {
                CoroutineScope(AndroidUiDispatcher.Main).launch {
                    pagerState.animateScrollToPage(0)
                }
            },
        )
        Tab(
            modifier = modifier,
            text = { Text("交易", fontSize = 12.sp) },
            selected = pagerState.currentPage == 1,
            onClick = {
                CoroutineScope(AndroidUiDispatcher.Main).launch {
                    pagerState.animateScrollToPage(1)
                }
            },
        )
        Tab(
            modifier = modifier,
            text = { Text("资讯", fontSize = 12.sp) },
            selected = pagerState.currentPage == 2,
            onClick = {
                CoroutineScope(AndroidUiDispatcher.Main).launch {
                    pagerState.animateScrollToPage(2)
                }
            },
        )
        Tab(
            modifier = modifier.wrapContentSize(),
            text = { Text("牛牛圈", fontSize = 12.sp) },
            selected = pagerState.currentPage == 3,
            onClick = {
                CoroutineScope(AndroidUiDispatcher.Main).launch {
                    pagerState.animateScrollToPage(3)
                }
            },
        )
        Tab(
            modifier = modifier,
            text = { Text("我的", fontSize = 12.sp) },
            selected = pagerState.currentPage == 4,
            onClick = {
                CoroutineScope(AndroidUiDispatcher.Main).launch {
                    pagerState.animateScrollToPage(4)
                }
            },
        )

    }
}