package kktyu.xyz.insidergame.themeconfirmation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kktyu.xyz.insidergame.MainActivity
import kktyu.xyz.insidergame.ThemeConfirmationFragmentDirections
import kktyu.xyz.insidergame.databinding.FragmentThemeConfirmationBinding

class ThemeConfirmationFragment : Fragment() {
    private var _binding: FragmentThemeConfirmationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThemeConfirmationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel =
            ThemeConfirmationViewModel()

        val mainActivity = activity as MainActivity
        val playersInfo = mainActivity.playersInfo

        val isLast = playersInfo.nextNum >= playersInfo.number
        binding.nextButton.text = viewModel.setButtonText(isLast)

        binding.themeText.text = mainActivity.theme

        binding.nextButton.setOnClickListener {
            when {
                isLast -> {
                    val action =
                        ThemeConfirmationFragmentDirections.actionThemeConfirmationFragmentToMasterConfirmationFragment()
                    it.findNavController().navigate(action)
                }
                else -> {
                    val action =
                        ThemeConfirmationFragmentDirections.actionThemeConfirmationFragmentToDisplayConfirmationFragment()
                    it.findNavController().navigate(action)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
