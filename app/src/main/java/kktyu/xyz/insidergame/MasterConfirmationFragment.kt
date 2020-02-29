package kktyu.xyz.insidergame


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_master_confirmation.*

class MasterConfirmationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_master_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        start_question_time_button.setOnClickListener {
            fragmentManager!!.beginTransaction().replace(
                R.id.nav_host_fragment,
                QuestionTimeFragment()
            ).commit()
        }
    }
}
