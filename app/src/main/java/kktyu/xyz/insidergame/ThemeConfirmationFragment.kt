package kktyu.xyz.insidergame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kktyu.xyz.insidergame.databinding.FragmentThemeConfirmationBinding

class ThemeConfirmationFragment : Fragment() {
    lateinit var binding: FragmentThemeConfirmationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThemeConfirmationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = ThemeConfirmationViewModel()

        val mainActivity = activity as MainActivity
        val playersInfo = mainActivity.playersInfo

        val isLast = playersInfo.nextNum >= playersInfo.number
        binding.viewModel!!.setButtonText(isLast)

        binding.viewModel!!.theme = mainActivity.theme

        binding.nextButton.setOnClickListener {
            when {
                isLast -> {
                    //TODO マスター確認画面へ
                }
                else -> {
                    fragmentManager!!.beginTransaction().replace(
                        R.id.container,
                        DisplayConfirmationFragment()
                    ).commit()
                }
            }
        }
    }
}
