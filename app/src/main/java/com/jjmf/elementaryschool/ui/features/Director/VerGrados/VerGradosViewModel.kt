package com.jjmf.elementaryschool.ui.features.Director.VerGrados

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.SeccionRepository
import com.jjmf.elementaryschool.model.Seccion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerGradosViewModel @Inject constructor(
    private val repository: SeccionRepository,
) : ViewModel() {

    var filtro by mutableStateOf("")
    var error by mutableStateOf<String?>(null)

    var list by mutableStateOf<List<Seccion>>(emptyList())

    fun getSeccion(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                list = repository.getList(0)
            }catch (e:Exception){
            }
        }
    }

}