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
    private var resultList = ArrayList<TestData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[BoardViewModel::class.java]
        viewModel.load()

        resultList = viewModel.list

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

        val adapter = MainTinyBoardListViewAdapter(context = aContext, list = resultList)
        recyclerView.adapter = adapter


        viewModel.ldata.observe(viewLifecycleOwner) {
            resultList = it
            println("observe data ${it.size}")

        }


    }

}