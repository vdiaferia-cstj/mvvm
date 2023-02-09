package com.example.mvvm.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.core.Constants
import com.example.mvvm.domain.models.Pilot
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val pilot = Pilot("YellowKiw", 15)

    private val _mainUiState = MutableStateFlow<MainUiState>(MainUiState.Empty)
    val mainUiState = _mainUiState.asStateFlow()

    init{
        _mainUiState.update {
            //return@update MainUiState.Success(pilot) ... même chose, écris differement
            MainUiState.Success(pilot)
        }
    }

    fun fly(revolution:Int, isTraining:Boolean){
        if (pilot.canFly()){
        viewModelScope.launch {
            //1. Changement d'état pour Loading (Animating)
            _mainUiState.update {
                MainUiState.Loading  //Démarrer l'animation
            }
            //2. Attendre x milliseconds
            delay(Constants.REVOLUTION_DURATION * revolution)

            //3. Voler
            pilot.fly(revolution, isTraining)

            //4. Changement d'état pour Success

            pilot.fly(revolution, isTraining)
            _mainUiState.update {
                //il pourrait avoir un return@update
                MainUiState.Success(pilot)
            }
        }






        } else {
            _mainUiState.update {
                //il pourrait avoir un return@update
                MainUiState.Error("Can't fly")
            }
        }
    }

    fun recharge() {
        pilot.recharge()
        _mainUiState.value = MainUiState.Success(pilot)
    }
}