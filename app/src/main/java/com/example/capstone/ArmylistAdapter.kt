package com.example.capstone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.models.ArmyList
import kotlinx.android.synthetic.main.item_armylist.view.*


class ArmylistAdapter (private val armyList: List<ArmyList>) : RecyclerView.Adapter<ArmylistAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_armylist, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(armyList [position])
    }

    override fun getItemCount(): Int {
        return armyList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun databind(armylist: ArmyList) {
            itemView.tvArmylistName.text = armylist.listName
            itemView.tvArmylistAllegience.text = armylist.alliance
        }
    }


}