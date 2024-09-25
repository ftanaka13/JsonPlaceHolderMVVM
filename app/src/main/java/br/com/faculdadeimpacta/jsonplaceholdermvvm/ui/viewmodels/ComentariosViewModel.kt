package br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.models.Comment
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.models.Post
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.repositories.ComentarioRepository
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.repositories.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ComentariosViewModel : ViewModel() {

    private var _post = MutableLiveData<Post>()
    private var _listaComentarios = MutableLiveData<List<Comment>>()

    private val postRepository = PostRepository()
    private val comentarioRepository = ComentarioRepository()

    fun getPost(): LiveData<Post> = _post
    fun getListaComentarios(): LiveData<List<Comment>> = _listaComentarios

    fun recuperaInformacoes(postId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _post.postValue(postRepository.getPost(postId))
            _listaComentarios.postValue(comentarioRepository.getComentarioPost(postId))
        }
    }

}