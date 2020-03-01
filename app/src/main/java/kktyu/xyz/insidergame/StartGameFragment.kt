package kktyu.xyz.insidergame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kktyu.xyz.insidergame.databinding.FragmentStartGameBinding

class StartGameFragment : Fragment() {
    private var _binding: FragmentStartGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity

        mainActivity.playersInfo.nextNum = 0

        binding.startGameBtn.setOnClickListener {
            val action =
                StartGameFragmentDirections.actionStartGameFragmentToSelectNumberFragment()
            it.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
