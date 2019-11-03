package org.daredevils2512.yes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MatchViewModel : ViewModel() {
    private var eventCode = MutableLiveData<String>()
    var EventCode : String?
    get() = eventCode.value
    set(value) {
        eventCode.value = value
    }
}