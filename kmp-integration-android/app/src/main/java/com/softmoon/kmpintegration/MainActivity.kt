package com.softmoon.kmpintegration

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.softmoon.kmpintegration.ui.theme.KmpintegrationTheme
import com.softmoon.ktorkmm.data.remote.KtorHttpClient
import com.softmoon.ktorkmm.data.remote.NetworkClientProvider
import com.softmoon.ktorkmm.data.remote.NetworkLogLevel
import com.softmoon.ktorkmm.data.response.Launch
import com.softmoon.ktorkmm.data.services.LaunchService

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KmpintegrationTheme {
                var launches by remember { mutableStateOf(emptyList<Launch>()) }
                LaunchedEffect(Unit) {
                    val client = KtorHttpClient.Builder()
                        .enableLogs(networkLogLevel = NetworkLogLevel.ALL)
                        .baseUrl("https://api.spacexdata.com")
                        .build()
                    val networkProvider = NetworkClientProvider.create(client)

                    val service = LaunchService(networkProvider)

                    launches = service.getLaunches()
                }
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column {
                        launches.forEach {
                            Greeting("${it.rocket} - ${it.flightNumber} ~> ${it.success}")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KmpintegrationTheme {
        Greeting("Android")
    }
}