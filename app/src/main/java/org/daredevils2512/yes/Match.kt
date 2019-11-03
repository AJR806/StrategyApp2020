package org.daredevils2512.yes

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import java.io.File

class Match : Fragment() {

    private lateinit var viewModel : MatchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this)[MatchViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_match, container, false)
        val matchStartButton: Button = view.findViewById(R.id.match_start)
        matchStartButton.text = viewModel.EventCode
        //val path = context.getFilesDir()
        //val letDirectory = File(path, "LET")
        //letDirectory.mkdirs()
        //val file = File(letDirectory, "matchDATA.txt")
        return view
    }
    //public abstract File getDir (matchdatas, 0)
}
