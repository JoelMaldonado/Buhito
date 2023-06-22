package com.jjmf.elementaryschool.ui.features.Profesor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjmf.elementaryschool.app.BaseApp.Companion.prefs
import com.jjmf.elementaryschool.data.repository.CursoRepository
import com.jjmf.elementaryschool.data.repository.SeccionRepository
import com.jjmf.elementaryschool.data.repository.UsuarioRepository
import com.jjmf.elementaryschool.model.SeccionUsuario
import com.jjmf.elementaryschool.model.Usuario
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuProfesorViewModel @Inject constructor(
    private val repository: UsuarioRepository,
    private val repoCurso: CursoRepository,
    private val repoSeccion: SeccionRepository,
) : ViewModel() {

    private val _user: MutableStateFlow<Usuario?> = MutableStateFlow(null)
    val user: StateFlow<Usuario?> = _user

    private val _list: MutableStateFlow<List<SeccionUsuario>> = MutableStateFlow(emptyList())
    val list: StateFlow<List<SeccionUsuario>> = _list


    init {
        viewModelScope.launch(Dispatchers.IO) {
            _user.value = repository.getList().find { it.id == prefs.getId() }
        }
    }

}