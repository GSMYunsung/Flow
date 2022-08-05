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

            lifecycleScope.launch{

               val ages = ageList.asFlow()
                    ages.onEach{ age ->
                        check(age < 50) {
                            "Error on value : $age"
                        }
                    } .catch { e ->
                        Log.e("TAG", e.toString())
                    }.collect{ age ->
                        Log.d("TAG", "Value : $age")
                }
            }



        }
    }