package br.com.faculdadeimpacta.jsonplaceholdermvvm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.faculdadeimpacta.jsonplaceholdermvvm.R
import br.com.faculdadeimpacta.jsonplaceholdermvvm.databinding.FragmentListaPostsBinding


class ListaPostsFragment : Fragment() {

    private var _binding: FragmentListaPostsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListaPostsBinding.inflate(inflater, container, false)
        return binding.root
    }


}