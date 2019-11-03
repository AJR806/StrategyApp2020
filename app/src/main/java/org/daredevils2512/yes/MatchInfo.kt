package org.daredevils2512.yes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import java.lang.Exception

class MatchInfo : Fragment() {

    private lateinit var viewModel: MatchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this)[MatchViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.match_info_fragment, container, false)

        val eventCodeEditText: EditText = view.findViewById(R.id.event_code)

        val allianceSpinner: Spinner = view.findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(view.context, R.array.colors, R.layout.better_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            allianceSpinner.adapter = adapter
        }

        val matchTypeSpinner: Spinner = view.findViewById(R.id.match_type_spinner)
        ArrayAdapter.createFromResource(view.context, R.array.match_type, R.layout.better_spinner_item).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                matchTypeSpinner.adapter = adapter
            }

        val matchReadyButton: Button = view.findViewById(R.id.match_ready_button)
        matchReadyButton.setOnClickListener {view ->
            viewModel.EventCode = eventCodeEditText.text.toString()
            view.findNavController().navigate(R.id.action_match_ready)
        }

        return view
    }

}
