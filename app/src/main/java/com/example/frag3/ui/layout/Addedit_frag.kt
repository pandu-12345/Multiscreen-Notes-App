package com.example.frag3.ui.layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.frag3.MainActivity
import com.example.frag3.R
import com.example.frag3.databinding.FragmentAddEditFragBinding
import com.example.frag3.ui.viewmodel.NotesViewModel
import com.example.fragment_app.Data.Entity.Notes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class addedit_frag : Fragment(R.layout.fragment_add_edit_frag) {
    private var _binding:FragmentAddEditFragBinding?=null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val noteViewModel: NotesViewModel by viewModels()
        val args:addedit_fragArgs by navArgs()
        val note=args.myData
        // Inflate the layout for this fragment
        _binding=FragmentAddEditFragBinding.inflate(inflater,container,false)
        binding.apply {


            if(note!=null) {
                Title.setText(note.title)
                Des.setText(note.des)
                DeleteButton.setOnClickListener {
                    noteViewModel.delete(note)
                    onClick()
                }
                SaveButton.setOnClickListener{
                    val title=Title.text.toString()
                    val des=Des.text.toString()

                        noteViewModel.update(Notes(title, des, note.id))

                    onClick()
                }

            }else{
                DeleteButton.setOnClickListener {
                    onClick()
                }
                SaveButton.setOnClickListener{
                    val title=Title.text.toString()
                    val des=Des.text.toString()
                    noteViewModel.insert(Notes(title,des))
                    onClick()
                }

            }
            BackButton.setOnClickListener{
                onClick()
            }
        }
        return binding.root

    }

   private fun onClick(){
       findNavController().popBackStack()
   }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}