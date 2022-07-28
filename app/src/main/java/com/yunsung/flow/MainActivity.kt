package com.yunsung.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        lifecycleScope.launch { numFlow()
            .collectLatest {

                delay(200)
                Log.d("TAG", "Log2 : ${Thread.currentThread().name}")
            }
            }

        }
    }

    private fun numFlow() : Flow<Int> = flow{
        for( i in 1..10 ){
            delay(100)
            Log.d("TAG" , "Log1 : ${Thread.currentThread().name}")
            emit(i)
        }


}