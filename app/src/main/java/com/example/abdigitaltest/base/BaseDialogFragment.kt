package com.example.abdigitaltest.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.example.abdigitaltest.R

abstract class BaseDialogFragment<T : ViewBinding> : DialogFragment() {

    abstract fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): T

    private var _binding: T? = null
    val binding get() = _binding!!
    val bindingSafe get() = _binding

    override fun getTheme(): Int {
        return R.style.RoundedDialogTheme
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = initBinding(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}