package br.com.faculdadeimpacta.jsonplaceholdermvvm.data.datasources.remote

import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.models.Comment
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.models.Post
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.models.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderEndpoints {

    @GET("posts")
    suspend fun getListaPosts(): List<Post>

    @GET("posts/{postId}")
    suspend fun getPost(@Path("postId") postId: Int): Post

    @GET("posts/{postId}/comments")
    suspend fun getPostComments(@Path("postId") postId: Int): List<Comment>

    @GET("users/{userId}")
    suspend fun getAutor(@Path("userId") userId: Int): User

    companion object {
        private var INSTANCE: Retrofit? = null
        fun getInstance(): Retrofit {
            if (INSTANCE == null) {
                val instance = Retrofit
                    .Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                INSTANCE = instance
            }
            return INSTANCE!!;
        }
    }

}