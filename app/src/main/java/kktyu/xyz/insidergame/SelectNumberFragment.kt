package kktyu.xyz.insidergame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import kktyu.xyz.insidergame.databinding.FragmentSelectNumberBinding
import kotlinx.android.synthetic.main.fragment_select_number.*
import kotlin.random.Random

class SelectNumberFragment : Fragment() {
    lateinit var binding: FragmentSelectNumberBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSpinner()

        start_btn.setOnClickListener {
            val selectedNumber = selected_number.text.toString().toInt()
            val master = Random.nextInt(selectedNumber)
            val insider = choiceInsider(selectedNumber, master)

            val bundle = Bundle()

            bundle.putInt("master", master)
            bundle.putInt("insider", insider)


        }
    }

    private fun choiceInsider(selectedNumber: Int, master: Int): Int {
        var insider = Random.nextInt(selectedNumber)

        while (master == insider) {
            insider = Random.nextInt(selectedNumber)
        }

        return insider
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
                selected_number.text = item
            }

            //　アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}
