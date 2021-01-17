package com.example.capstone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.capstone.models.ArmyList
import com.example.capstone.repository.armylistRepository
import kotlinx.android.synthetic.main.fragment_add_armylist.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

const val REQ_ARMY_KEY = "req_armylist"
const val BUNDLE_ARMY_KEY = "bundle_armylist"

class AddArmylistFragment : Fragment() {

    private lateinit var repository: armylistRepository

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_armylist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repository = armylistRepository(requireContext())
        btnAddArmylist.setOnClickListener{
            onAddArmy()
        }
    }

    private fun onAddArmy() {
        val armylistName = txtArmyName.text.toString()
        val heroes = txtHeroes.text.toString()
        val battlelineUnits = txtBattleline.text.toString()
        val units = txtunits.text.toString()
        val alligence = txtArmyAlliegence.text.toString()
        val armylistresponse = ArmyList(null, armylistName, alligence, heroes, battlelineUnits, units, artillery = "", behemoths = "")


        if (armylistName.isNotBlank()){
            CoroutineScope(Dispatchers.Main).launch{
                withContext(Dispatchers.IO){
                    repository.insertArmylist(armylistresponse)
                }
            }
            findNavController().popBackStack()
        }
        else{
            Toast.makeText(activity, R.string.not_valid, Toast.LENGTH_SHORT).show()
        }

    }
}