package br.com.faculdadeimpacta.jsonplaceholdermvvm.data.repositories

import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.datasources.remote.JsonPlaceHolderEndpoints
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.models.Post

class PostRepository {

    private val retrofit = JsonPlaceHolderEndpoints.getInstance()
    private val endpoints = retrofit.create(JsonPlaceHolderEndpoints::class.java)

    suspend fun getListaPosts(): List<Post> {
        return endpoints.getListaPosts()
    }

    suspend fun getPost(postId: Int): Post {
        return endpoints.getPost(postId)
    }

}