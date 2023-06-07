package com.jjmf.elementaryschool.ui.features.Director.VerGrados

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.GradoRepository
import com.jjmf.elementaryschool.model.Grado
import com.jjmf.elementaryschool.model.Usuario
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerGradosViewModel @Inject constructor(
    private val repository: GradoRepository,
) : ViewModel() {

    var filtro by mutableStateOf("")
    var error by mutableStateOf<String?>(null)
    var listGrado by mutableStateOf<List<Grado>>(emptyList())
    var listGradoMain by mutableStateOf<List<Grado>>(emptyList())

    fun getGrados() {
        viewModelScope.launch(Dispatchers.IO){
            try {
                repository.getListFlow().collect(){list->
                    listGradoMain = list
                    listGrado = listGradoMain
                }
            }catch (e:Exception){
                error = e.message
            }
        }
    }

    fun deleteGrado(grado: Grado) {
        viewModelScope.launch(Dispatchers.IO){
            try {
                repository.delete(grado)
            }catch (e:Exception){
                error = e.message
            }
        }
    }
}