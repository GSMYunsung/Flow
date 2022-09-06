package com.yunsung.flow.study_flow.flow_collectLastest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.yunsung.flow.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class CollectLastestActivity : AppCompatActivity() {

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