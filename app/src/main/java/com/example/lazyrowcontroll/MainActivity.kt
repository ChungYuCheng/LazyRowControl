package com.example.lazyrowcontroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazyrowcontroll.ui.theme.LazyRowControllTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyRowControllTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val stateRowTop = rememberLazyListState() // State for the first Row, X
                    val stateRowX = rememberLazyListState() // State for the first Row, X
                    val stateRowY = rememberLazyListState() // State for the second Row, Y
                    val stateRowZ = rememberLazyListState() // State for the second Row, Y
                    val stateRowXX = rememberLazyListState() // State for the second Row, Y
                    val scope = rememberCoroutineScope()
                    val scrollState = rememberScrollableState{ delta->
                        scope.launch{
                            stateRowX.scrollBy(-delta)
                            stateRowY.scrollBy(-delta)
                            stateRowZ.scrollBy(-delta)
                            stateRowXX.scrollBy(-delta)
                            stateRowTop.scrollBy(-delta)
                        }
                        delta
                    }

//                    LazyRow(state = stateRowTop, userScrollEnabled = false){
//                        stickyHeader{
//                            Surface(Modifier.fillMaxWidth()) {
//                                TitleTopAndDown()
//                            }
//                        }
//                        items(20){index->
//                            TitleTopAndDown()
//                        }
//                    }
                    LazyColumn( // 整張表
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .scrollable(
                                scrollState,
                                orientation = Orientation.Horizontal,
                                flingBehavior = ScrollableDefaults.flingBehavior()
                            )
                    ) {
                        stickyHeader {
                            LazyRow(state = stateRowTop, userScrollEnabled = false){
                                stickyHeader{
                                    Surface(Modifier.fillMaxWidth()) {
                                        TitleTopAndDown()
                                    }
                                }
                                items(20){index->
                                    TitleTopAndDown()
                                }
                            }
                        }
//                        item {
//                            LazyRow(state = stateRowTop, userScrollEnabled = false){
//                                stickyHeader{
//                                    Surface(Modifier.fillMaxWidth()) {
//                                        TitleTopAndDown()
//                                    }
//                                }
//                                items(20){index->
//                                    TitleTopAndDown()
//                                }
//                            }
//                        }

                        item {
                            LazyRow(state = stateRowX, userScrollEnabled = false, modifier = Modifier.height(250.dp)){
                                stickyHeader{
                                    Surface(Modifier.fillMaxWidth()) {
                                        CustomStickyHeader()
                                    }
                                }
                                items(20){index->
                                    Column() {
                                        Text(text = "測試 ${index}-1", modifier = Modifier.padding(horizontal = 5.dp))
                                        Text(text = "測試 ${index}-1", modifier = Modifier.padding(horizontal = 5.dp))
                                        Text(text = "測試 ${index}-1", modifier = Modifier.padding(horizontal = 5.dp))
                                        Text(text = "測試 ${index}-1", modifier = Modifier.padding(horizontal = 5.dp))
                                    }
                                }
                            }
                        }
                        item {
                            LazyRow(state = stateRowY, userScrollEnabled = false, modifier = Modifier.height(250.dp)){
                                stickyHeader{
                                    Surface(Modifier.fillMaxWidth()) {
                                        CustomStickyHeader()
                                    }
                                }
                                items(20){index->
                                    Column() {
                                        Text(text = "測試 ${index}-2", modifier = Modifier.padding(horizontal = 5.dp))
                                        Text(text = "測試 ${index}-2", modifier = Modifier.padding(horizontal = 5.dp))
                                        Text(text = "測試 ${index}-2", modifier = Modifier.padding(horizontal = 5.dp))
                                        Text(text = "測試 ${index}-2", modifier = Modifier.padding(horizontal = 5.dp))
                                    }

                                }
                            }
                        }
                        item {
                            LazyRow(state = stateRowZ, userScrollEnabled = false, modifier = Modifier.height(250.dp)){
                                stickyHeader{
                                    Surface(Modifier.fillMaxWidth()) {
                                        CustomStickyHeader()
                                    }
                                }
                                items(20){index->
                                    Column() {
                                        Text(text = "測試 ${index}-3", modifier = Modifier.padding(horizontal = 5.dp))
                                        Text(text = "測試 ${index}-3", modifier = Modifier.padding(horizontal = 5.dp))
                                        Text(text = "測試 ${index}-3", modifier = Modifier.padding(horizontal = 5.dp))
                                        Text(text = "測試 ${index}-3", modifier = Modifier.padding(horizontal = 5.dp))
                                    }

                                }
                            }
                        }
                        item {
                            LazyRow(state = stateRowXX, userScrollEnabled = false, modifier = Modifier.height(250.dp)){
                                stickyHeader{
                                    Surface(Modifier.fillMaxWidth()) {
                                        CustomStickyHeader()
                                    }
                                }
                                items(20){index->
                                    Column() {
                                        Text(text = "測試 ${index}-4", modifier = Modifier.padding(horizontal = 5.dp))
                                        Text(text = "測試 ${index}-4", modifier = Modifier.padding(horizontal = 5.dp))
                                        Text(text = "測試 ${index}-4", modifier = Modifier.padding(horizontal = 5.dp))
                                        Text(text = "測試 ${index}-4", modifier = Modifier.padding(horizontal = 5.dp))
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomStickyHeader() {
    Row(modifier = Modifier.height(IntrinsicSize.Min)) {
        Box(modifier = Modifier
            .fillMaxHeight()
            .width(80.dp)) {
            Text(text = "總計", modifier = Modifier.align(Alignment.Center))
        }
        Column() {
            Text(text = "核單量", )
            Text(text = "拋檔量", )
            Text(text = "完成量", )
            Text(text = "未完成量", )
        }
    }

}

@Composable
fun RepoTitle(stateRowTop: LazyListState) {
    LazyRow(state = stateRowTop, userScrollEnabled = false) {
        items(20) { index ->
           TitleTopAndDown()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TitleTopAndDown() {
    Column(modifier = Modifier
        .background(Color.Gray)
        .width(70.dp)) {
        Text(text = "倉別", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Text(text = "日期", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
    }
}


@Composable
fun ScrollableHorizontalData(gridState: LazyGridState) {
    val sections = (0 until 25).toList().chunked(5)
    LazyHorizontalGrid(
        modifier = Modifier.height(300.dp),
        state = gridState,
        rows = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        sections.forEachIndexed { index, items ->
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    "This is section $index",
                    Modifier
                        .border(1.dp, Color.Gray)
                        .width(80.dp)
                        .wrapContentSize()
                )
            }
            items(
                items,
                // not required as it is the default
                span = { GridItemSpan(1) }
            ) {
                Text(
                    "Item $it",
                    Modifier
                        .border(1.dp, Color.Blue)
                        .width(80.dp)
                        .wrapContentSize()
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun TwoLazyRows() {
    val stateRowX = rememberLazyListState() // State for the first Row, X
    val stateRowY = rememberLazyListState() // State for the second Row, Y
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollableState{delta->
        scope.launch{
            stateRowX.scrollBy(-delta)
            stateRowY.scrollBy(-delta)
        }
        delta
    }


    LazyColumn(modifier = Modifier
        .padding(top = 20.dp)
        .scrollable(
            scrollState,
            orientation = Orientation.Horizontal,
            flingBehavior = ScrollableDefaults.flingBehavior()
        )
    ){
        items(2) {
            LazyRow(state = stateRowX, userScrollEnabled = false){
                stickyHeader{
                    Text(text = "測試 titile-1", modifier = Modifier.padding(horizontal = 5.dp))
                }
                items(20){index->
                    Text(text = "測試 ${index}-1", modifier = Modifier.padding(horizontal = 5.dp))
                }
            }


            Spacer(Modifier.height(20.dp))

            LazyRow(state = stateRowY, userScrollEnabled = false){
                stickyHeader{
                    Text(text = "測試 titile-2", modifier = Modifier.padding(horizontal = 5.dp))
                }
                items(20){index->
                    Text(text = "測試 ${index}-2", modifier = Modifier.padding(horizontal = 5.dp))
                }
            }

            Spacer(Modifier.height(20.dp))
        }

    }
}