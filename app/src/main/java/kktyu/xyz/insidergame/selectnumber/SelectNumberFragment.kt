package kktyu.xyz.insidergame.selectnumber

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kktyu.xyz.insidergame.MainActivity
import kktyu.xyz.insidergame.databinding.FragmentSelectNumberBinding
import kotlinx.android.synthetic.main.fragment_select_number.*

class SelectNumberFragment : Fragment() {
    private var _binding: FragmentSelectNumberBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSpinner()

        val viewModel = SelectNumberViewModel()

        start_btn.setOnClickListener {
            val selectedNumber = binding.selectedNumber.text.toString().toInt()
            val master = viewModel.choiceMaster(selectedNumber)
            val insider = viewModel.choiceInsider(selectedNumber, master)

            val mainActivity = activity as MainActivity

            mainActivity.apply {
                playersInfo.number = selectedNumber
                playersInfo.master = master
                playersInfo.insider = insider
            }

            val action =
                SelectNumberFragmentDirections.actionSelectNumberFragmentToDisplayConfirmationFragment()
            it.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private fun setSpinner() {
        val spinnerItems = mutableListOf<String>()
        for (n in 3..10) {
            spinnerItems.add(n.toString())
        }
        val adapter = ArrayAdapter(
            activity!!.applicationContext,
            android.R.layout.simple_spinner_item,
            spinnerItems
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        select_number.adapter = adapter

        select_number.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //　アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                // Kotlin Android Extensions
                binding.selectedNumber.text = item
            }

            //　アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}
