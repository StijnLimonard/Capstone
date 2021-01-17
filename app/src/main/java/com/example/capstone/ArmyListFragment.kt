package com.example.capstone

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.models.ArmyList
import com.example.capstone.repository.armylistRepository
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        observeAddarmyResult()
        repository = armylistRepository(requireContext())
        getArmiesFromDatabase()


    }

    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        rvArmyLists.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvArmyLists.adapter = armylistAdapter
        rvArmyLists.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        //createItemTouchHelper().attachToRecyclerView(rvReminders)
    }

    private fun getArmiesFromDatabase(){
        CoroutineScope(Dispatchers.Main).launch {
            val armies = withContext(Dispatchers.IO){
                repository.getAllArmylists()
            }
            this@ArmyListFragment.armylists.clear()
            this@ArmyListFragment.armylists.addAll(armies)
            armylistAdapter.notifyDataSetChanged()
        }
    }

    private fun observeAddarmyResult() {
        setFragmentResultListener(REQ_ARMY_KEY) { key, bundle ->
            bundle.get(BUNDLE_ARMY_KEY)?.let {
                val army = it
                CoroutineScope(Dispatchers.Main).launch {
                    withContext(Dispatchers.IO) {
                        repository.insertArmylist(army as ArmyList)
                    }
                    getArmiesFromDatabase()
                }

            } ?: Log.e("ArmylistFragment", "Request triggered, but empty text!")

        }
    }

}