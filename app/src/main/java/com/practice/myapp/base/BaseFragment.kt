package com.practice.myapp.base

import androidx.fragment.app.Fragment
import javax.inject.Inject

open class BaseFragment : Fragment() {

    @Inject
    lateinit var viewModeFactory: ViewModelFactory


}