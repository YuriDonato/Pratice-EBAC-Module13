package com.example.modulo13tarefa

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import com.example.modulo13tarefa.CustomObserver
import com.example.modulo13tarefa.HomeFragmentDirections
import com.example.modulo13tarefa.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater,container,false)
        val startGameButton = binding.startActivityButton

//        if(savedInstanceState?.containsKey("editTextValue") == true){
//            val value = savedInstanceState.getString("editTextValue")
//            editText.setText(value)
//        }

        startGameButton.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToGameNav()
            findNavController().navigate(action)
        }

        lifecycle.addObserver(CustomObserver())

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //outState.putString("editTextValue",editText.text.toString())
    }
}
