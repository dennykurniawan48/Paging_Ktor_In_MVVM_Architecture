package com.signaltekno.paging3androidcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.signaltekno.paging3androidcompose.ui.theme.Paging3AndroidComposeTheme
import com.signaltekno.paging3androidcompose.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: PostViewModel by viewModels()
        viewModel.getDatax()

        setContent {
            val result by viewModel.datax.observeAsState()
            if(result is NetworkResult.Loading){
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator()
                }
            }else if(result is NetworkResult.Error){
                Text("Error showing data", modifier = Modifier.size(40.dp))
            }else if(result is NetworkResult.Success) {
                LazyColumn {
                    if (result != null) {
                        items(result!!.data!!.results) {
                            Text(it.name)
                        }
                    }
                }
            }
        }
    }
}
