package com.yunsung.flow.study_flow.flow_exception

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.yunsung.flow.R
import com.yunsung.flow.ageList
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ExceptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        lifecycleScope.launch{

            val ages = ageList.asFlow().map { age ->
                check(age < 50) {
                    "Error on value : $age"
                }
                age
            }

            try {
                ages.collect{ age ->

//                        check(age < 50) {
//                            "Error on value : $age"
//                        }

                    Log.d("TAG", "value : $age")
                }
            }
            catch (e : Exception){
                Log.d("TAG", e.toString())
            }
        }

        // 선언형 예외처리

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

        // catch

        lifecycleScope.launch{

            val ages = ageList.asFlow()
            ages.catch{ e ->

                Log.e("TAG", e.toString())

            }.collect{ age ->
                Log.d("TAG", "Value : $age")
            }
        }

    }
}