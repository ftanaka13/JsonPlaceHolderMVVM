package br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import br.com.faculdadeimpacta.jsonplaceholdermvvm.R
import br.com.faculdadeimpacta.jsonplaceholdermvvm.databinding.FragmentPostAutorBinding
import br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.viewmodels.AutorViewModel

class PostAutorFragment : Fragment() {

    private var _binding: FragmentPostAutorBinding? = null
    private val binding get() = _binding!!
    private val args: PostAutorFragmentArgs by navArgs()
    private val viewModel: AutorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPostAutorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        viewModel.autor.observe(viewLifecycleOwner) { usuario ->
            binding.usuario = usuario
        }

        viewModel.getInfoAutor(args.userId)
    }

}