package com.example.frag3.ui.layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.frag3.R
import com.example.frag3.adapter.NotesAdapter
import com.example.frag3.databinding.FragmentNoteFragBinding
import com.example.frag3.ui.viewmodel.NotesViewModel
import com.example.fragment_app.Data.Entity.Notes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Notefrag : Fragment(R.layout.fragment_note_frag),NotesAdapter.OnClick {

    private var _binding:FragmentNoteFragBinding?=null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val noteViewModel: NotesViewModel by viewModels()
        _binding=FragmentNoteFragBinding.inflate(inflater,container,false)


        binding.apply {
            recyclerView.layoutManager=GridLayoutManager(context,2)
            AddButton.setOnClickListener{
                val action=NotefragDirections.actionNotefragToAddeditFrag()
                findNavController().navigate(action)
            }
            noteViewModel.allNotes.observe(viewLifecycleOwner) {
                val adapter = NotesAdapter(it, this@Notefrag)
                recyclerView.adapter = adapter
              //  adapter.notifyDataSetChanged()
            }

        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    override fun onClickListner(notes: Notes) {
        val action=NotefragDirections.actionNotefragToAddeditFrag(notes)
        findNavController().navigate(action)
    }

}