package com.example.abdigitaltest.util.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.abdigitaltest.R
import com.example.abdigitaltest.base.BaseDialogFragment
import com.example.abdigitaltest.databinding.DialogCustomBinding

class CustomDialog: BaseDialogFragment<DialogCustomBinding>() {


    companion object {
        private val MESSAGE = "MESSAGE"
        private val IS_INFORM = "IS_INFORM"

        fun newInstance(
            message: String,
            isInform: Boolean
        ): CustomDialog {
            return CustomDialog().apply {
                arguments = Bundle().apply {
                    putString(MESSAGE, message)

                    putBoolean(IS_INFORM, isInform)
                }
            }
        }
    }

    override fun getTheme(): Int {
        return R.style.CustomDialog
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): DialogCustomBinding {
        return DialogCustomBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        this.isCancelable = false
        val title = arguments?.getString(MESSAGE, "")
        binding.tvTitle.text = title

    }
}