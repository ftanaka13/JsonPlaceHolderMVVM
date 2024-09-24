package br.com.faculdadeimpacta.jsonplaceholdermvvm.data.repositories

import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.datasources.remote.JsonPlaceHolderEndpoints
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.models.Comment

class ComentarioRepository {

    private val retrofit = JsonPlaceHolderEndpoints.getInstance()
    private val endpoints = retrofit.create(JsonPlaceHolderEndpoints::class.java)

    suspend fun getComentarioPost(postId: Int): List<Comment> {
        return endpoints.getPostComments(postId)
    }
}