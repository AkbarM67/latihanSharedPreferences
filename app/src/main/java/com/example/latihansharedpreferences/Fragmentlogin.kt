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
import com.example.latihansharedpreferences.databinding.FragmentloginBinding


class Fragmentlogin : Fragment() {
    lateinit var binding: FragmentloginBinding
    lateinit var sharedlogin: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentloginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedlogin = requireContext().getSharedPreferences("datauser", Context.MODE_PRIVATE)

        binding.Registrasi.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentlogin_to_fragment_Registrasi)
        }
        binding.btnPindah1.setOnClickListener {
            var dataUserName = sharedlogin.getString("UserName", "")
            var dataUserPw = sharedlogin.getString("Upassword", "")
            var user = binding.editNama.text.toString()
            var pw = binding.editPassword.text.toString()

            if (user.isEmpty() || pw.isEmpty()) {
                Toast.makeText(context, "ISI password dan User name anda", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else {
                if (user == dataUserName.toString() && pw == dataUserPw.toString()) {
                    findNavController().navigate(R.id.action_fragmentlogin_to_fragment_home)
                    Toast.makeText(context, "anda berhasil login ", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(context, "username dan password anda salah", Toast.LENGTH_LONG)
                        .show()
                    return@setOnClickListener
                }
            }
        }
    }
}