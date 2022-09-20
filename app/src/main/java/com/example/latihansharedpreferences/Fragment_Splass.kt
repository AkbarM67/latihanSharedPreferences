package com.example.latihansharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.latihansharedpreferences.databinding.FragmentSplassBinding


class Fragment_Splass : Fragment() {
    lateinit var binding : FragmentSplassBinding
    lateinit var shared : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment__splass, container, false)
        binding = FragmentSplassBinding.inflate(layoutInflater)
        val view = binding.root


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.myLooper()!!).postDelayed({

            shared = requireContext().getSharedPreferences("datauser",Context.MODE_PRIVATE)
            if (shared.getString("UserName","").equals("")){
                findNavController().navigate(R.id.action_fragment_Splass_to_fragmentlogin)
            }else if (shared.getString("UserName","")!!.length >0){
                findNavController().navigate(R.id.action_fragment_Splass_to_fragment_home)
            }
        },3000)
    }
}