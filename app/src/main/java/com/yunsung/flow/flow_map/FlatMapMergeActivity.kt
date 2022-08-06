package com.yunsung.flow.flow_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.yunsung.flow.R
import com.yunsung.flow.ageList
import com.yunsung.flow.userList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class FlatMapMergeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        lifecycleScope.launch{
            val startTime = System.currentTimeMillis()
            ageList.asFlow()
                .onEach { delay(100) }
                .flatMapMerge { age ->
                    userList.asFlow().map { user ->
                        delay(400)
                        "Age : $age - User : $user - Time : ${System.currentTimeMillis() - startTime}"
                    }
                }.collect{
                    Log.d("TAG", it.toString())
                }

        }

    }
}