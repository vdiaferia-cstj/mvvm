package com.example.mvvm.presentation.main

import android.os.Message
import com.example.mvvm.domain.models.Pilot

// class PilotUiState(val isSuccess:Boolean,val pilot: Pilot)


sealed class PilotUiState{
    class Success(val pilot: Pilot): PilotUiState()
    object Loading: PilotUiState()
    class Error(val message: String): PilotUiState()
    object Empty: PilotUiState()

}

//isError => pilot == null
//isSuccess => pilot == Pilot()
//isLoading => pilot == null
//isEmpty => pilot == null