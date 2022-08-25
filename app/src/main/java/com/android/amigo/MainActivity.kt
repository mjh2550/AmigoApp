package com.android.amigo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.amigo.databinding.ActivityMainBinding
import com.android.amigo.view.viewmodel.BoardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment
    lateinit var binding: ActivityMainBinding

    private val viewModel: BoardViewModel by viewModels()

//    private lateinit var viewModel: BoardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        componentBinding()

/*        val call = viewModel.load()
        var list = ArrayList<Any>()

        call.enqueue(object : Callback<ArrayList<Any>> {
            override fun onResponse(
                call: Call<ArrayList<Any>>,
                response: Response<ArrayList<Any>>
            ) {
                if (response.isSuccessful) {
                    var result = response.body()!!
                    for (test in result) {
                        Log.d("Test", "For : $test")
                    }
                    Log.d("Test", "OnRequest Success : $result")
                    //여기서 바로 핸들링
                    list = result
                } else {
                    Log.e("Test", "OnRequest Fail")
                }
            }

            override fun onFailure(call: Call<ArrayList<Any>>, t: Throwable) {
                Log.d("Test", "On Fail : ${t.message}")
            }
        })*/

    }

    private fun componentBinding() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        binding.bottomNavigationView.setupWithNavController(navController)
    }


}