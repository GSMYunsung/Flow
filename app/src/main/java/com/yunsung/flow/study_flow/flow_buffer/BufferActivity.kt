package com.yunsung.flow.study_flow.flow_buffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.yunsung.flow.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class BufferActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        lifecycleScope.launch { numFlow()
            //.buffer()
            //.conflate()
            .collect{ it->
                Log.d("TAG" , "Log2 : ${Thread.currentThread().name} : $it")

            } }

    }
}


private fun numFlow() : Flow<Int> = flow{
    for( i in 1..10 ){
        Log.d("TAG" , "Log1 : ${Thread.currentThread().name}")
        emit(i)
    }


}