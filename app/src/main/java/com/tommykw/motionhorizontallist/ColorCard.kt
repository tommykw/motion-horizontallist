package com.tommykw.motionhorizontallist

import androidx.annotation.ColorRes
import androidx.recyclerview.widget.DiffUtil

inline class ColorCardId(
    val id: Int
)

data class ColorCard(
    val id: ColorCardId,
    val name: String,
    @ColorRes val backgroundResId: Int
)

object ColorCardDiff : DiffUtil.ItemCallback<ColorCard>() {
    override fun areItemsTheSame(oldItem: ColorCard, newItem: ColorCard) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: ColorCard, newItem: ColorCard) = oldItem == newItem
}

val colorCards = listOf(
    ColorCard(
        id = ColorCardId(1),
        name = "Grey",
        backgroundResId = R.color.grey_900
    ),
    ColorCard(
        id = ColorCardId(2),
        name = "Blue",
        backgroundResId = R.color.blue_900
    ),
    ColorCard(
        id = ColorCardId(3),
        name = "Green",
        backgroundResId = R.color.green_900
    ),
    ColorCard(
        id = ColorCardId(4),
        name = "Red",
        backgroundResId = R.color.red_900
    ),
    ColorCard(
        id = ColorCardId(5),
        name = "Yellow",
        backgroundResId = R.color.yellow_900
    ),
    ColorCard(
        id = ColorCardId(6),
        name = "Orange",
        backgroundResId = R.color.orange_900
    ),
    ColorCard(
        id = ColorCardId(7),
        name = "Pink",
        backgroundResId = R.color.pink_900
    ),
    ColorCard(
        id = ColorCardId(8),
        name = "Grey",
        backgroundResId = R.color.grey_900
    ),
    ColorCard(
        id = ColorCardId(9),
        name = "Blue",
        backgroundResId = R.color.blue_900
    ),
    ColorCard(
        id = ColorCardId(10),
        name = "Green",
        backgroundResId = R.color.green_900
    ),
    ColorCard(
        id = ColorCardId(11),
        name = "Teal",
        backgroundResId = R.color.teal_900
    )
)