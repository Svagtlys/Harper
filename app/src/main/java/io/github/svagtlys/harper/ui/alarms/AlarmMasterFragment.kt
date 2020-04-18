package io.github.svagtlys.harper.ui.alarms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.svagtlys.harper.R

class AlarmMasterFragment : Fragment() {

//    internal var callback: OnAddAlarmSelectedListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView : View = inflater.inflate(R.layout.fragment_alarm_master, container, false)

        val addAlarmButton : View = rootView.findViewById(R.id.addAlarmButton)

//        addAlarmButton.setOnClickListener {
//            var nextFrag : AlarmAddFragment = AlarmAddFragment()
//            activity.supportFragmentManager.beginTransaction()
//                .replace(R.id.nav_host_fragment_container, nextFrag, "Alarm Adder")
//                .addToBackStack(null)
//                .commit()
//        }

        // Inflate the layout for this fragment
        return rootView
    }
    
//    interface OnAddAlarmSelectedListener {
//        fun on
//    }

}