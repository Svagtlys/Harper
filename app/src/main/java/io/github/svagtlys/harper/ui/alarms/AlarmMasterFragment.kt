package io.github.svagtlys.harper.ui.alarms

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.github.svagtlys.harper.R
import java.lang.IllegalArgumentException
import java.lang.RuntimeException

class AlarmMasterFragment : Fragment() {

    private lateinit var listener: AlarmMasterFragmentListener
    private lateinit var addAlarmButton: FloatingActionButton

    //Interface to interact with Activity
    interface AlarmMasterFragmentListener {
        fun onAddAlarmButtonClick() : Unit
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView : View = inflater.inflate(R.layout.fragment_alarm_master, container, false)

        addAlarmButton = rootView.findViewById(R.id.addAlarmButton)
        addAlarmButton.setOnClickListener{
            view ->
                listener.onAddAlarmButtonClick()
        }

        // Inflate the layout for this fragment
        return rootView
    }

    //Check if activity fragment is in (context) implements listener interface
    override fun onAttach(context: Context) {
        super.onAttach(context)
        println("attaching")
        if (context is AlarmMasterFragmentListener) {
            println("Setting listener")
            listener = context
        } else {
            throw RuntimeException("$context must implement AlarmMasterFragmentListener")
        }
    }

}