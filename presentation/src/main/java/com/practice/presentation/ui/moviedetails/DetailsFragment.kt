package com.practice.presentation.ui.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.practice.domain.entity.Movie
import com.practice.presentation.base.BaseFragment
import com.practice.presentation.databinding.FragmentDetailsBinding
import com.practice.presentation.extension.loadImageUrl

class DetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val navArgs by navArgs<DetailsFragmentArgs>()
    private var movie: Movie? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDetailsBinding.inflate(inflater, container, false).apply {
        binding = this
        initValues()
        initUI()
        initListeners()
    }.root

    private fun initValues() {
        movie = navArgs.movieItem
    }

    private fun initUI() {
        binding.tvTitle.text = movie?.movieTitle ?: ""
        binding.ivBg.loadImageUrl(movie?.moviePosterUrl ?: "")
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}