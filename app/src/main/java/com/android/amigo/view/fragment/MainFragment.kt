package com.android.amigo.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.android.amigo.R
import com.android.amigo.domain.model.TestData
import com.android.amigo.view.adapter.MainTinyBoardListViewAdapter
import com.android.amigo.view.viewmodel.BoardViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var btn01: Button
    lateinit var aContext: Context
    lateinit var recyclerView: RecyclerView

    lateinit var viewModel: BoardViewModel


//    private val viewModel by activityViewModels<BoardViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        aContext = requireActivity()
        navController = Navigation.findNavController(view)
        recyclerView = view.findViewById(R.id.list_1)
        viewModel = ViewModelProvider(requireActivity())[BoardViewModel::class.java]
        val testbtn = view.findViewById<Button>(R.id.button)
        testbtn.setOnClickListener {
            viewModel.ldata.value?.add(TestData("t", "tv"))
            println("ok ${viewModel.ldata.value}")
//            recyclerView.adapter?.notifyItemInserted(viewModel.ldata.value?.size!!)
        }

        viewModel.load()

        var resultList = ArrayList<TestData>()
        resultList.add(TestData("t1", "test1"))
        resultList.add(TestData("t2", "test2"))
        resultList.add(TestData("t3", "test2"))


        val adapter = MainTinyBoardListViewAdapter(context = aContext, list = resultList)
        recyclerView.adapter = adapter


        viewModel.ldata.observe(viewLifecycleOwner) {
            resultList = it
            println("observe data ${it.size}")

        }
    }

}