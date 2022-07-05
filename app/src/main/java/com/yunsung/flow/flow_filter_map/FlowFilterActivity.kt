package com.yunsung.flow.flow_filter_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.yunsung.flow.R
import com.yunsung.flow.ageList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FlowFilterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow_filter)

        lifecycleScope.launch(Dispatchers.IO) {
            ageList.asFlow()
                .filter { age -> age % 3 == 1}
                .map { age ->
                    "Age : $age"
                }
                .collect{
                        age-> Log.d("TAG" , age.toString())
                }
        }

    }
}