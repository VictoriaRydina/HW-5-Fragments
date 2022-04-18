package com.example.hw_5_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.hw_5_fragments.databinding.DetailsContactBinding

class ContactDetails : Fragment(R.layout.details_contact) {

    private lateinit var binding: DetailsContactBinding
    private val dataModel: DataModel by activityViewModels()
    private var newId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailsContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        putId()
        saveChanged()
    }

    private fun putId(){
        dataModel.dataId.observe(activity as LifecycleOwner){
            newId = it
        }
        binding.apply {
            editName.setText(contacts[newId].name)
            editSurname.setText(contacts[newId].surname)
            editNumber.setText(contacts[newId].number)
        }
    }

    private fun saveChanged() {
        binding.apply {
            saveBtn.setOnClickListener {
                contacts[newId].name = editName.text.toString()
                contacts[newId].surname = editSurname.text.toString()
                contacts[newId].number = editNumber.text.toString()
                openFrag(ContactList(), R.id.activity_frame_layout)
            }
        }
    }

    private fun openFrag(f: Fragment, idLayout: Int){
        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.activity_frame_layout,
            ContactList()
        )?.addToBackStack(null)?.commit()
    }
}