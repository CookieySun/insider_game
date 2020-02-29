package kktyu.xyz.insidergame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        binding.startGameBtn.setOnClickListener {
            fragmentManager!!.beginTransaction().replace(
                R.id.nav_host_fragment,
                SelectNumberFragment()
            ).commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
