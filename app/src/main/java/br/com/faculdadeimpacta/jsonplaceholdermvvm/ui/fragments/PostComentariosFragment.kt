package br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import br.com.faculdadeimpacta.jsonplaceholdermvvm.R
import br.com.faculdadeimpacta.jsonplaceholdermvvm.databinding.FragmentPostComentariosBinding


class PostComentariosFragment : Fragment() {

    private var _binding: FragmentPostComentariosBinding? = null
    private val binding get() = _binding!!
    private val args: PostComentariosFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPostComentariosBinding.inflate(inflater, container, false)
        return binding.root
    }
}