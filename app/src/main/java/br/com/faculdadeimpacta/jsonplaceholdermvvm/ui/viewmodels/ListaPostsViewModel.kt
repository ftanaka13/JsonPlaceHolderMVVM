package br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.models.Post
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.repositories.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListaPostsViewModel : ViewModel() {

    private var _listaPosts = MutableLiveData<List<Post>>()
    val listaPosts: LiveData<List<Post>> = _listaPosts
    private val postRepository = PostRepository()

    fun getListaPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            val lista = postRepository.getListaPosts()
            _listaPosts.postValue(lista)
        }
    }
}