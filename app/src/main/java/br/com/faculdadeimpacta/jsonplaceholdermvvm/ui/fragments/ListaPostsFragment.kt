package br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.faculdadeimpacta.jsonplaceholdermvvm.R
import br.com.faculdadeimpacta.jsonplaceholdermvvm.databinding.FragmentListaPostsBinding
import br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.adapters.PostAdapter
import br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.viewmodels.ListaPostsViewModel


class ListaPostsFragment : Fragment() {

    private var _binding: FragmentListaPostsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ListaPostsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListaPostsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        viewModel.listaPosts.observe(viewLifecycleOwner) { lista ->
            binding.recyclerViewPosts.adapter = PostAdapter(lista, { userId ->
                val acao =
                    ListaPostsFragmentDirections.actionListaPostsFragmentToPostAutorFragment(userId)
                findNavController().navigate(acao)
            }) { postId ->
                val acao =
                    ListaPostsFragmentDirections.actionListaPostsFragmentToPostComentariosFragment(
                        postId
                    )
                findNavController().navigate(acao)
            }
            binding.recyclerViewPosts.layoutManager = LinearLayoutManager(activity)
        }

        viewModel.getListaPosts()
    }


}