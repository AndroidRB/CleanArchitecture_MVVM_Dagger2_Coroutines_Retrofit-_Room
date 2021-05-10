package com.practice.myapp.ui.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.practice.myapp.base.BaseFragment
import com.practice.myapp.databinding.FragmentDetailsBinding
import com.practice.myapp.extension.loadImageUrl
import com.practice.myapp.mapper.model.MovieDetailsItem

class DetailsFragment : BaseFragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding

    private val navArgs by navArgs<DetailsFragmentArgs>()
    private var movieItem: MovieDetailsItem? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDetailsBinding.inflate(inflater, container, false).apply {
        _binding = this
        initValues()
        initUI()
        initListeners()
    }.root

    private fun initValues() {
        movieItem = navArgs.movieItem
    }

    private fun initUI() {
        binding?.tvTitle?.text = movieItem?.movieTitle ?: ""
        binding?.ivBg?.loadImageUrl(movieItem?.moviePosterUrl ?: "")
    }

    private fun initListeners() {
        binding?.ivBack?.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}