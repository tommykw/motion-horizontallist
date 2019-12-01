package com.tommykw.motionhorizontallist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import com.tommykw.motionhorizontallist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val cards: MutableList<ColorCard> by lazy {
        colorCards.toMutableList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = cards[0].name

        binding.list.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            val listWidth = (cards.size - 1) * binding.list.width
            val offsetWidth = binding.list.computeHorizontalScrollOffset()
            val index = offsetWidth * 10 / listWidth
            val itemMotionLayout = binding.list.findChildViewUnder(scrollX.toFloat(), scrollY.toFloat())
                    as? MotionLayout ?: return@setOnScrollChangeListener

            if (oldScrollX > 60 || oldScrollX < -60) {
                if (itemMotionLayout.currentState == R.id.start && (itemMotionLayout.progress == 0.0f || itemMotionLayout.progress == 1.0f)) {
                    itemMotionLayout.setTransition(R.id.start, R.id.end)
                    itemMotionLayout.setTransition(R.id.end, R.id.left)
                    itemMotionLayout.setTransitionDuration(1000)
                    itemMotionLayout.transitionToEnd()
                } else if (itemMotionLayout.currentState == R.id.left && itemMotionLayout.progress == 1.0f) {
                    itemMotionLayout.setTransition(R.id.left, R.id.end)
                    itemMotionLayout.setTransition(R.id.end, R.id.start)
                    itemMotionLayout.setTransitionDuration(1000)
                    itemMotionLayout.transitionToEnd()
                }
            }

            binding.textView.text = cards[index].name
        }

        val onClick = object : ColorCardViewClick {
            override fun onClick(view: View, colorCard: ColorCard) {
                val index = cards.indexOf(colorCard)
                binding.textView.text = cards[index].name

                (view as? MotionLayout)?.setTransitionListener(object : MotionLayout.TransitionListener {
                    override fun onTransitionTrigger(
                            p0: MotionLayout?,
                            p1: Int,
                            p2: Boolean,
                            p3: Float
                    ) {
                    }

                    override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                    }

                    override fun onTransitionChange(
                            p0: MotionLayout?,
                            p1: Int,
                            p2: Int,
                            p3: Float
                    ) {
                    }

                    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                    }
                })
            }
        }

        binding.list.apply {
            setHasFixedSize(true)
            adapter = ColorCardAdapter(onClick).apply {
                submitList(cards)
            }
        }
    }
}