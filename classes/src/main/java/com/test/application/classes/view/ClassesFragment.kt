package com.test.application.classes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import gb.com.educational_app.databinding.FragmentClassesBinding
import gb.com.educational_app.model.datasource.Classes
import org.koin.androidx.viewmodel.ext.android.viewModel


class ClassesFragment : Fragment() {

    private var _binding: FragmentClassesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ClassesViewModel by viewModel()

    companion object {
        fun newInstance() = ClassesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClassesBinding.inflate(inflater, container, false)
        initObservers()
        viewModel.loadClasses()
        return binding.root
    }

    private fun initObservers() {
        viewModel.classes.observe(viewLifecycleOwner) { classes ->
            initClassesRecyclerView(classes)
        }
    }

    private fun initClassesRecyclerView(classes: List<Classes>) {
        val adapter = ClassesFragmentAdapter()
        adapter.classesList = classes
        binding.classesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.classesRecyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}