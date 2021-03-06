package com.practice.presentation.base

import android.content.Context
import androidx.fragment.app.Fragment
import com.practice.presentation.di.injector.Injector
import javax.inject.Inject

abstract class BaseFragment : Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as Injector)
            .createFragmentSubComponent()
            .inject(this)
    }
}