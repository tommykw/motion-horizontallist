package com.tommykw.motionhorizontallist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tommykw.motionhorizontallist.databinding.ColorCardItemBinding

class ColorCardAdapter(
    private val onClick: ColorCardViewClick
) : ListAdapter<ColorCard, ColorCardViewHolder>(ColorCardDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorCardViewHolder {
        return ColorCardViewHolder(
            ColorCardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ColorCardViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
    }
}

interface ColorCardViewClick {
    fun onClick(view: View, colorCard: ColorCard)
}

class ColorCardViewHolder(
    private val binding: ColorCardItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(colorCard: ColorCard, colorCardViewClick: ColorCardViewClick) {
        val context = binding.root.context

        binding.colorCardImage.run {
            this.setOnClickListener {
                colorCardViewClick.onClick(binding.root, colorCard)
            }

            this.setCardBackgroundColor(context.getColor(colorCard.backgroundResId))
        }
    }
}
