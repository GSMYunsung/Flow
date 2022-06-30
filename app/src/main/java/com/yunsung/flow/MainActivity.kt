package com.yunsung.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        CoroutineScope(Dispatchers.IO).launch {
               launch {

//                   withTimeoutOrNull(5000){
//                       simpleFlow().collect{ user ->
//                           Log.d("TAG", user)
//                       }
//                   }

               }
            }

        lifecycleScope.launch(Dispatchers.IO) {
            simpleFlow().collect{ user ->
                Log.d("TAG", user)
            }
        }

        }
    }

    private fun simpleFlow() : Flow<String> = flow {
        userList.forEach { user-> emit(user)
            delay(500)
        }
}