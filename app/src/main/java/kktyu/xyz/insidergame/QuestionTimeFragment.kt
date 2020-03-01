package kktyu.xyz.insidergame


import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kktyu.xyz.insidergame.databinding.FragmentCountDownBinding

class QuestionTimeFragment : Fragment() {
    private var _binding: FragmentCountDownBinding? = null
    private val binding get() = _binding!!

    private val timer by lazy {
        object : CountDownTimer(300000, 250) {
            override fun onTick(millisUntilFinished: Long) {
                val millisSec = millisUntilFinished / 1000
                val sec = "%02d".format(millisSec % 60)
                val min = millisSec / 60

                binding.remainingTimeText.text = "$min:$sec"
            }

            override fun onFinish() {
                beginDiscussionTimeFragment()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountDownBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        timer.start()

        binding.answerButton.setOnClickListener {
            beginDiscussionTimeFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        timer.cancel()
        _binding = null
    }

    private fun beginDiscussionTimeFragment() {
        val action =
            QuestionTimeFragmentDirections.actionQuestionTimeFragmentToDiscussionTimeFragment()
        view!!.findNavController().navigate(action)
    }
}
