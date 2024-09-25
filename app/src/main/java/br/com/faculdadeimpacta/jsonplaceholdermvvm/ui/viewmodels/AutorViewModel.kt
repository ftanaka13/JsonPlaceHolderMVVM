package br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.models.User
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.repositories.AutorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AutorViewModel : ViewModel() {

    private var _autor = MutableLiveData<User>()
    val autor: LiveData<User> = _autor

    private var autorRepository = AutorRepository()

    fun getInfoAutor(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _autor.postValue(autorRepository.getAutor(userId))
        }
    }

}