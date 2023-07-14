package com.example.lazyrowcontroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lazyrowcontroll.ui.theme.LazyRowControllTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyRowControllTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(6) { index ->
                            val gridState = rememberLazyGridState()
                            Row(modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,) {
                                CustomStickyHeader()
                                GoogleAns2(gridState)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomStickyHeader() {
    Box(modifier = Modifier.height(300.dp)) {
        Text(text = "固定標題", modifier = Modifier.align(Alignment.Center))
    }
}


@Composable
fun GoogleAns2(gridState: LazyGridState) {
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