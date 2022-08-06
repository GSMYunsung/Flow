package com.yunsung.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class MainActivity : AppCompatActivity() {

    @OptIn(FlowPreview::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

            lifecycleScope.launch{
               val startTime = System.currentTimeMillis()
                ageList.asFlow()
                    .onEach { delay(1000) }
                    .flatMapLatest { age ->
                        userList.asFlow().map { user ->
                            delay(500)
                            "Age : $age - User : $user - Time : ${System.currentTimeMillis() - startTime}"
                        }
                    }.collect{
                        Log.d("TAG", it.toString())
                    }

            }



        }
    }