package com.simsekselim.multiplebackstacks.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simsekselim.multiplebackstacks.MainActivity
import com.simsekselim.multiplebackstacks.R
import com.simsekselim.multiplebackstacks.home.adapter.HomeAdapter


class HomeFragment : Fragment() {
    private var viewModel: HomeViewModel? = null
    private var adapter: HomeAdapter? = null
    private var recycler: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        recycler = view.findViewById(R.id.recycler)
        recycler?.layoutManager = LinearLayoutManager(context)
        adapter = HomeAdapter(viewModel?.items?.value.orEmpty())
        recycler?.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter?.onItemClicked = {
            findNavController().navigate(R.id.action_homeFragment_to_homeDetailFragment)
        }
    }
}