package br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.faculdadeimpacta.jsonplaceholdermvvm.R
import br.com.faculdadeimpacta.jsonplaceholdermvvm.databinding.FragmentPostComentariosBinding
import br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.adapters.ComentarioAdapter
import br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.viewmodels.ComentariosViewModel


class PostComentariosFragment : Fragment() {

    private var _binding: FragmentPostComentariosBinding? = null
    private val binding get() = _binding!!
    private val args: PostComentariosFragmentArgs by navArgs()
    private val viewModel: ComentariosViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPostComentariosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        viewModel.getPost().observe(viewLifecycleOwner) { post ->
            binding.post = post
        }
        viewModel.getListaComentarios().observe(viewLifecycleOwner) { lista ->
            binding.recyclerViewComentarios.adapter = ComentarioAdapter(lista)
            binding.recyclerViewComentarios.layoutManager = LinearLayoutManager(activity)
        }
        viewModel.recuperaInformacoes(args.postId)

    }
}