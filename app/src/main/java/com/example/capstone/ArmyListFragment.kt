package com.example.capstone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.models.ArmyList
import com.example.capstone.repository.armylistRepository
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ArmyListFragment : Fragment() {

    private lateinit var repository: armylistRepository

    private val armylists : ArrayList<ArmyList> = arrayListOf()
    private  val armylistAdapter = ArmylistAdapter(armylists)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        repository = armylistRepository(requireContext())


//        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        rvArmyLists.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvArmyLists.adapter = armylistAdapter
        rvArmyLists.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        //createItemTouchHelper().attachToRecyclerView(rvReminders)
    }
}