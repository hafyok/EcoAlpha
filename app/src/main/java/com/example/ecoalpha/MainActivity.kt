package com.example.ecoalpha

import ApiInterface
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecoalpha.data.BinCardInfo
import com.example.ecoalpha.ui.theme.EcoAlphaTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    private lateinit var apiInterface: ApiInterface
    private fun getApiInterface(){
        apiInterface = RetrofitInstance.getInstance().create(ApiInterface::class.java)
    }
    private fun getExampleData(){
        val call = apiInterface.getCardData()
        call.enqueue(object : Callback<BinCardInfo>{
            override fun onResponse(request: Call<BinCardInfo>, response: Response<BinCardInfo>) {
                if (response.isSuccessful && response.body() != null){
                    Log.d("rtrft", response.body().toString())
                }
            }

            override fun onFailure(request: Call<BinCardInfo>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getApiInterface()
        getExampleData()

        enableEdgeToEdge()
        setContent {
            EcoAlphaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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
    EcoAlphaTheme {
        Greeting("Android")
    }
}