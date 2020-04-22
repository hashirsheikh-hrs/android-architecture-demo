package com.hrs.presentation.mainactivity.firstfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrs.*
import com.hrs.databinding.FragmentFirstBinding
import com.hrs.model.GitHubRepo
import com.hrs.presentation.mainactivity.MainActivity

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
    lateinit var firstViewModel: FirstViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFirstBinding.bind(view)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter =
            FirstAdapter()
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        val appComponent = (requireActivity().application as MainApplication).appComponent
        firstViewModel = ViewModelProvider(this,
            FirstViewModelFactory(
                requireActivity().application,
                appComponent.gitRepoDao(),
                appComponent.gitHubService()
            )
        ).get(FirstViewModel::class.java)
        firstViewModel.changeUser("square")
        firstViewModel.data.observe(viewLifecycleOwner,
            Observer<List<GitHubRepo>> { (binding.recyclerView.adapter as FirstAdapter).setRepos(it) })
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        (requireActivity() as MainActivity).mainActivityComponent.inject(this)
    }
}
