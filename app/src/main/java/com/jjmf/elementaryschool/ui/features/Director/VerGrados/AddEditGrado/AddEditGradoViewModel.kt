package com.jjmf.elementaryschool.ui.features.Director.VerGrados.AddEditGrado

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.GradoRepository
import com.jjmf.elementaryschool.model.Grado
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditGradoViewModel @Inject constructor(
    private val repository: GradoRepository,
) : ViewModel() {
    var detalle by mutableStateOf("")
    var seccion by mutableStateOf("")

    var error by mutableStateOf<String?>(null)
    var back by mutableStateOf(false)

    fun insertarCurso() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val grado = Grado(
                    detalle = detalle,
                    seccion = seccion
                )
                repository.insert(grado = grado)
                back = true
            } catch (e: Exception) {
                error = e.message
            }
        }
    }

}