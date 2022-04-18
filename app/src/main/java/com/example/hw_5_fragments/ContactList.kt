package com.example.hw_5_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.hw_5_fragments.databinding.ListContactBinding

class ContactList : Fragment(R.layout.list_contact) {

    private lateinit var binding: ListContactBinding
    private val dataModel: DataModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListContactBinding.inflate(inflater, container, false)

        binding.tvName.text = contacts[0].name
        binding.tvName2.text = contacts[1].name
        binding.tvName3.text = contacts[2].name
        binding.tvName4.text = contacts[3].name

        binding.tvSurname.text = contacts[0].surname
        binding.tvSurname2.text = contacts[1].surname
        binding.tvSurname3.text = contacts[2].surname
        binding.tvSurname4.text = contacts[3].surname

        binding.tvNumber.text = contacts[0].number
        binding.tvNumber2.text = contacts[1].number
        binding.tvNumber3.text = contacts[2].number
        binding.tvNumber4.text = contacts[3].number

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickContact()
    }

    private fun clickContact(){
        binding.apply {
            contOne.setOnClickListener {
                dataModel.dataId.value = 0
                openFrag(ContactDetails(), R.id.activity_frame_layout)
            }
            contTwo.setOnClickListener {
                dataModel.dataId.value = 1
                openFrag(ContactDetails(), R.id.activity_frame_layout)
            }
            contThree.setOnClickListener {
                dataModel.dataId.value = 2
                openFrag(ContactDetails(), R.id.activity_frame_layout)
            }
            contFour.setOnClickListener {
                dataModel.dataId.value = 3
                openFrag(ContactDetails(), R.id.activity_frame_layout)
            }
        }
    }

    private fun openFrag(f: Fragment, idLayout: Int){
        activity?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.activity_frame_layout,
            ContactDetails()
        )?.addToBackStack(null)?.commit()
    }
}