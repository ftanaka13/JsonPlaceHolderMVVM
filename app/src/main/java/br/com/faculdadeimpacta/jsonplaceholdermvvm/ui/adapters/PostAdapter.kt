package br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.faculdadeimpacta.jsonplaceholdermvvm.data.models.Post
import br.com.faculdadeimpacta.jsonplaceholdermvvm.databinding.PostItemBinding

class PostAdapter(private val listaPost: List<Post>) : RecyclerView.Adapter<PostAdapter.PostVH>() {

    inner class PostVH(private val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(post: Post) {
            binding.post = post
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PostItemBinding.inflate(layoutInflater, parent, false)
        return PostVH(binding)
    }

    override fun onBindViewHolder(holder: PostVH, position: Int) {
        holder.onBind(listaPost[position])
    }

    override fun getItemCount(): Int = listaPost.size

}