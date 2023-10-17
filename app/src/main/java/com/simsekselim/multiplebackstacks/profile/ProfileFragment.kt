package com.simsekselim.multiplebackstacks.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.simsekselim.multiplebackstacks.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
            view.findViewById<Button>(R.id.profile_detail).setOnClickListener {
                findNavController().navigate(R.id.action_profileFragment_to_profileDetailFragment)
            }
        return view
    }
}