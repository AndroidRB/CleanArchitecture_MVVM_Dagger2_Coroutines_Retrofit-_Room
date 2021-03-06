package com.practice.presentation.base

import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    abstract val viewModeFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        DaggerApplicationGraph.builder()
//            .application(context.applicationContext as Application)
//            .build()
//            .inject(this)
    }
}