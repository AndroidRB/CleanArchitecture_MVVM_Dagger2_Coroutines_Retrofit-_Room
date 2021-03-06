package com.practice.presentation.base

import android.content.Context
import androidx.fragment.app.Fragment
import com.practice.presentation.di.Injector

abstract class BaseFragment : Fragment() {

    abstract val viewModeFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as Injector)
            .createFragmentSubComponent()
            .inject(this)
    }
}