package kktyu.xyz.insidergame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kktyu.xyz.insidergame.databinding.FragmentRoleConfirmationBinding

class RoleConfirmationFragment : Fragment() {
    lateinit var binding: FragmentRoleConfirmationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRoleConfirmationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity
        val nextNum = mainActivity.playersInfo.nextNum

        val isMasterOrInsider =
            (nextNum == mainActivity.playersInfo.master || nextNum == mainActivity.playersInfo.insider)

        val isLast = mainActivity.playersInfo.nextNum >= mainActivity.playersInfo.number

        binding.displayRole.text = if (!isMasterOrInsider) {
            "市民"
        } else if (nextNum == mainActivity.playersInfo.master) {
            "マスター"
        } else {
            "インサイダー"
        }

        binding.nextButton.text =
            when {
                isMasterOrInsider -> {
                    "お題確認へ"
                }
                isLast -> {
                    "マスター確認"
                }
                else -> {
                    (mainActivity.playersInfo.nextNum + 1).toString() + "人目へ"
                }
            }

        binding.nextButton.setOnClickListener {
            when {
                isMasterOrInsider -> {
                    fragmentManager!!.beginTransaction().replace(
                        R.id.container,
                        ThemeConfirmationFragment()
                    ).commit()
                }
                isLast -> {
                    fragmentManager!!.beginTransaction().replace(
                        R.id.container,
                        MasterConfirmationFragment()
                    ).commit()
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
