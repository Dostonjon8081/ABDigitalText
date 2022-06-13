package com.example.abdigitaltest.util.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.abdigitaltest.R
import com.example.abdigitaltest.base.BaseDialogFragment
import com.example.abdigitaltest.databinding.DialogCustomBinding
import com.example.abdigitaltest.util.extension.gone
import com.example.abdigitaltest.util.extension.show

class CustomDialog: BaseDialogFragment<DialogCustomBinding>() {
    var callback: OnDialogCallback? = null

    companion object {
        private val MESSAGE = "MESSAGE"
        private val CANCEL_TEXT = "CANCEL_TEXT"
        private val SUCCESS_TEXT = "SUCCESS_TEXT"
        private val IS_INFORM = "IS_INFORM"

        fun newInstance(
            message: String,
            cancelBtnText: String,
            successBtnText: String,
            isInform: Boolean
        ): CustomDialog {
            return CustomDialog().apply {
                arguments = Bundle().apply {
                    putString(MESSAGE, message)
                    putString(CANCEL_TEXT, cancelBtnText)
                    putString(SUCCESS_TEXT, successBtnText)
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
        val cancelBtnText = arguments?.getString(CANCEL_TEXT, "")
        val successBtnText = arguments?.getString(SUCCESS_TEXT, "")
        val isInform = arguments?.getBoolean(IS_INFORM, true)

        if (isInform == false) {
            binding.tvBtnCancel.show()
        } else {
            binding.tvBtnCancel.gone()
        }

        binding.tvTitle.text = title
        binding.tvBtnCancel.text = cancelBtnText
        binding.tvBtnSuccess.text = successBtnText

        binding.tvBtnCancel.setOnClickListener {
            callback?.onCancel()
        }

        binding.tvBtnSuccess.setOnClickListener {
            callback?.onSuccess()
        }


    }

    interface OnDialogCallback {
        fun onSuccess()
        fun onCancel()
    }
}