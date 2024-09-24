package br.com.faculdadeimpacta.jsonplaceholdermvvm.data.repositories

import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.datasources.remote.JsonPlaceHolderEndpoints
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.models.User

class AutorRepository {

    private val retrofit = JsonPlaceHolderEndpoints.getInstance()
    private val endpoints = retrofit.create(JsonPlaceHolderEndpoints::class.java)

    suspend fun getAutor(userId: Int): User {
        return endpoints.getAutor(userId)
    }

}