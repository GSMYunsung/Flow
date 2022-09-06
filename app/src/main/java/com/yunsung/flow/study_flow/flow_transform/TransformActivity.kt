package com.yunsung.flow.study_flow.flow_transform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.yunsung.flow.R
import com.yunsung.flow.ageList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch

class TransformActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        // 중간연산자 (flow) 는 요소마다 1 개의 변환 밖에 하지못하지만
        // 변환연산자 (transform) 은 매 주기마다 여러개의 변환이 가능합니다.

       lifecycleScope.launch(Dispatchers.IO) {
            ageList.asFlow()
                .transform { age ->
                   emit("Age : $age . The Value is Getting transformed")
                   emit("Age : $age")
                }
                .collect{
                    value -> Log.d("TAG" , value)
                }
        }
    }
}