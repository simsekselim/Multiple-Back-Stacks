package com.simsekselim.multiplebackstacks.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.simsekselim.multiplebackstacks.R

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_search, container, false)
        view.findViewById<Button>(R.id.search_detail).setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_searchDetailFragment)
        }
        return view
    }
}