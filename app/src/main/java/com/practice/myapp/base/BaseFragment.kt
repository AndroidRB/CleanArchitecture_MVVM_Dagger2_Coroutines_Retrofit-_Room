package com.practice.myapp.base

import android.content.Context
import androidx.fragment.app.Fragment
import javax.inject.Inject

open class BaseFragment : Fragment() {

    @Inject
    lateinit var viewModeFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }
}