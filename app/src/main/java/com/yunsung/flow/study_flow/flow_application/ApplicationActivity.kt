package com.yunsung.flow.study_flow.flow_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.yunsung.flow.R
import com.yunsung.flow.ageList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch

class ApplicationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

//        lifecycleScope.launch(Dispatchers.IO){
//            try {
//                ageFlow().collect{ value ->
//                    Log.d("TAG",value.toString())
//                }
//            }
//            finally {
//                Log.d("TAG","Flow has completed")
//            }
//        }

        lifecycleScope.launch(Dispatchers.IO){
            ageFlow()
                .onCompletion { Log.d("TAG", "Completion") }
        }

    }

    private fun ageFlow() : Flow<Int> = ageList.asFlow()
        .transform { age -> if(age == 30){
            emit(age + 1)
        } else {
            emit(age)
        }

        }
}