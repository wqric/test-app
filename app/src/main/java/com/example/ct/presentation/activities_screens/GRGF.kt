package com.example.ct.presentation.activities_screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ct.ui.theme.CTTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun M() {
    val scope = rememberCoroutineScope()
    val refreshing = remember { mutableStateOf(false) }
    val count = remember { mutableStateOf(1) }
    val state = rememberPullRefreshState(refreshing.value, {
        scope.launch {
            refreshing.value = true
            delay(2000)
            count.value++
            refreshing.value = false
        }

    })
    Box(Modifier.fillMaxSize().pullRefresh(state)) {
        LazyColumn(Modifier.fillMaxSize()) {
            items(count.value) {
                Text(text = it.toString())
            }
        }
        PullRefreshIndicator(
            refreshing = refreshing.value,
            state = state,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

@Preview
@Composable
fun MPreview() {
    CTTheme {
        M()
    }
}