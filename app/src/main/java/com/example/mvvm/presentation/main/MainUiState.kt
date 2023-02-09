package com.example.mvvm.presentation.main

import com.example.mvvm.domain.models.Pilot

// class PilotUiState(val isSuccess:Boolean,val pilot: Pilot)


sealed class MainUiState{
    class Success(val pilot: Pilot): MainUiState()
    object Loading: MainUiState() // N'est pas toujours présent object = static
    class Error(val message: String): MainUiState()
    object Empty: MainUiState() // N'est pas toujours présent

}

//isError => pilot == null
//isSuccess => pilot == Pilot()
//isLoading => pilot == null
//isEmpty => pilot == null