package com.jjmf.elementaryschool.ui.features.Director.VerGrados.VerSalon

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.app.BaseApp.Companion.prefs
import com.jjmf.elementaryschool.data.repository.SeccionUsuarioRepository
import com.jjmf.elementaryschool.data.usecase.GetSalon
import com.jjmf.elementaryschool.model.SeccionUsuario
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerSalonViewModel @Inject constructor(
    private val repository: SeccionUsuarioRepository,
    private val getSalon: GetSalon
) : ViewModel() {

    var list by mutableStateOf<List<SeccionUsuario>>(emptyList())

    fun getDatos(){
        viewModelScope.launch(Dispatchers.IO){
            getSalon(prefs.getId()).collect(){
                list = it
            }
        }
    }

}