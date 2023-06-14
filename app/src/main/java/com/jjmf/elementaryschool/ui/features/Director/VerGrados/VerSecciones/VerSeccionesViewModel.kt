package com.jjmf.elementaryschool.ui.features.Director.VerGrados.VerSecciones

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.data.repository.SeccionRepository
import com.jjmf.elementaryschool.model.Seccion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerSeccionesViewModel @Inject constructor(
    private val repository: SeccionRepository
) : ViewModel() {

    var error by mutableStateOf<String?>(null)

    private val _list = MutableStateFlow<List<Seccion>>(emptyList())
    val list : StateFlow<List<Seccion>> = _list

    fun getList(grado: Int){
        viewModelScope.launch(Dispatchers.IO){
            repository.getListFlow(grado).collect(){
                _list.value = it
            }
        }
    }

    fun insertarSeccion(grado:Int) {
        viewModelScope.launch(Dispatchers.IO){
            try {

                val cont = repository.getList(grado).maxByOrNull { it.detalle }?.detalle

                val final = if (cont!=null) cont + 1 else "A".single()

                val seccion = Seccion(
                    detalle = final,
                    grado = grado
                )
                repository.insert(seccion)

            }catch (e:Exception){
                error = e.message
            }
        }
    }

    fun deleteAll(grado:Int) {
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAll(grado)
        }
    }

    fun delete(seccion: Seccion) {
        viewModelScope.launch(Dispatchers.IO){
            repository.delete(seccion)
        }
    }

}