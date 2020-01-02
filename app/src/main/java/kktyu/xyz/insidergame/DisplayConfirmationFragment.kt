package kktyu.xyz.insidergame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kktyu.xyz.insidergame.databinding.FragmentDisplayConfirmationBinding

class DisplayConfirmationFragment : Fragment() {
    lateinit var binding: FragmentDisplayConfirmationBinding

    private var number = 0
    private var nextNum = 0
    private var master = 0
    private var insider = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainActivity = activity as MainActivity

        mainActivity.playersInfo.nextNum = ++mainActivity.playersInfo.nextNum

        number = mainActivity.playersInfo.number
        nextNum = mainActivity.playersInfo.nextNum
        master = mainActivity.playersInfo.master
        insider = mainActivity.playersInfo.insider
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDisplayConfirmationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.text = "$nextNum 人目の"

        binding.yesBtn.setOnClickListener {

        }
    }
}
