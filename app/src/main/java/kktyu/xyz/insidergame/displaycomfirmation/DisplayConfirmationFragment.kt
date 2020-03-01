package kktyu.xyz.insidergame.displaycomfirmation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kktyu.xyz.insidergame.DisplayConfirmationFragmentDirections
import kktyu.xyz.insidergame.MainActivity
import kktyu.xyz.insidergame.databinding.FragmentDisplayConfirmationBinding

class DisplayConfirmationFragment : Fragment() {
    private var _binding: FragmentDisplayConfirmationBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentDisplayConfirmationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.personSpot.text = "$nextNum 人目の"

        binding.yesBtn.setOnClickListener {

            val action =
                DisplayConfirmationFragmentDirections.actionDisplayConfirmationFragmentToRoleConfirmationFragment()
            it.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
