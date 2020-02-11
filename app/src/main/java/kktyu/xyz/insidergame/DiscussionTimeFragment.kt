package kktyu.xyz.insidergame


import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kktyu.xyz.insidergame.databinding.FragmentCountDownBinding


class DiscussionTimeFragment : Fragment() {
    lateinit var binding: FragmentCountDownBinding

    private val timer by lazy {
        object : CountDownTimer(300000, 250) {
            override fun onTick(millisUntilFinished: Long) {
                val millisSec = millisUntilFinished / 1000
                val sec = "%02d".format(millisSec % 60)
                val min = millisSec / 60

                binding.remainingTime = "$min:$sec"
            }

            override fun onFinish() {
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountDownBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var visible = false

        binding.answerButton.text = this.getText(R.string.discussion_finished)
        binding.questionTimeText.text = this.getText(R.string.discussion_time)
        binding.helpButton.apply {
            isVisible = true
            setOnClickListener {
                binding.descriptionText.isVisible = true
                if (!visible) {
                    fadein()
                    visible = !visible
                }
            }
        }

        binding.descriptionText.text = this.getText(R.string.description_discussion)

        binding.parentView.setOnClickListener {
            if (visible) {
                fadeout()
                visible = !visible
            }
        }

        timer.start()
    }


    override fun onDestroyView() {
        super.onDestroyView()

        timer.cancel()
    }

    private fun fadeout() { // 透明度を1から0に変化
        val alphaFadeout = AlphaAnimation(1.0f, 0.0f)
        // animation時間 msec
        alphaFadeout.duration = 500
        // animationが終わったそのまま表示にする
        alphaFadeout.fillAfter = true
        binding.descriptionText.startAnimation(alphaFadeout)
    }

    private fun fadein() { // 透明度を0から1に変化
        val alphaFadeIn = AlphaAnimation(0.0f, 1.0f)
        // animation時間 msec
        alphaFadeIn.duration = 500
        // animationが終わったそのまま表示にする
        alphaFadeIn.fillAfter = true
        binding.descriptionText.startAnimation(alphaFadeIn)
    }
}
