package com.halac123b.a7minuteworkout

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.halac123b.a7minuteworkout.databinding.ItemExerciseStatusBinding

// Creating an adapter class for RecyclerView using the item designed for it and along with Exercise Model class.)
class ExerciseStatusAdapter(val items: ArrayList<ExerciseModel>)
    : RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>(){

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder(binding: ItemExerciseStatusBinding): RecyclerView.ViewHolder(binding.root) {
        // Holds the TextView that will add each item to
        val tvItem = binding.tvItem
    }

    /**
     * Inflates the item view which is designed in xml layout file
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemExerciseStatusBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val model: ExerciseModel = items[position]
        holder.tvItem.text = model.getId().toString()

        // Updating the current item and the completed item in the UI and changing the background and text color according to it..
        // Updating the background and text color according to the flags that is in the list.
        when {
            model.getIsSelected() -> {
                holder.tvItem.background = ContextCompat.getDrawable(holder.itemView.context,
                    R.drawable.item_circular_thin_color_accent_border)
                // Parse the color string, and return the corresponding color-int.
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
            model.getIsCompleted() -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.item_circular_color_accent_background)
                holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))
            }
            else -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.item_circular_color_gray_background)
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
        }
    }

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return items.size
    }

}