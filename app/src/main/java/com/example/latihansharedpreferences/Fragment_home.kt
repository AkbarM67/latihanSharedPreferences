package com.example.latihansharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.latihansharedpreferences.databinding.FragmentHomeBinding
import com.example.latihansharedpreferences.databinding.FragmentRegistrasiBinding


class Fragment_home : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var shared : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shared = requireContext().getSharedPreferences("datauser",Context.MODE_PRIVATE)

        var datauser = shared.getString("UName","")
        binding.TextNama.text = "Hello "+ datauser.toString()

        binding.btnlogout.setOnClickListener {
            var pref = shared.edit()
            pref.clear()
            pref.apply()
            findNavController().navigate(R.id.action_fragment_home_to_fragmentlogin)
            Toast.makeText(context,"anda berhasil logout", Toast.LENGTH_SHORT).show()

        }
    }


}