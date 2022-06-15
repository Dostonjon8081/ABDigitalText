package com.example.abdigitaltest.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.viewbinding.ViewBinding
import com.example.abdigitaltest.util.dialog.CustomDialog
import com.example.abdigitaltest.util.extension.toast
import com.example.abdigitaltest.util.network.ConnectionLiveData
import com.example.abdigitaltest.util.network.LiveEvent
import com.example.abdigitaltest.util.network.NetworkServerAvailable
import kotlinx.coroutines.*
import javax.inject.Inject

abstract class BaseActivity<B : ViewBinding>(val bindingFactory: (LayoutInflater) -> B) :
    AppCompatActivity() {
    lateinit var binding: B
    var navController: NavController? = null
    var bottomNavController: NavController? = null


    var baseActivity: BaseActivity<B>? = null
    fun findFragmentByTag(tag: String?): Fragment? = supportFragmentManager.findFragmentByTag(tag)


    lateinit var observerError: Observer<String>
    lateinit var observerGoOffline: Observer<Boolean>

    var networkIssueDialogOpened: Boolean = false
    var checkNetworkConnectionJob: Job? = null

    @Inject
    lateinit var connectionLiveData: ConnectionLiveData

//    @Inject
//    @ErrorRemoteEvent
//    lateinit var errorRemote: LiveEvent<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)


        setContentView(binding.root)
        setupItems()

        baseActivity = this

        observerError = Observer {
            if (it == null) {
                toast("default_server_error",this)
            } else {
                showErrorDialog(it)
            }
        }

        observerGoOffline = Observer { isConnected ->
            if (!isConnected) {

            } else {
                if (networkIssueDialogOpened) {
                    checkNetworkConnectionJob?.cancel()

                    checkNetworkConnectionJob = GlobalScope.launch(Dispatchers.IO) {
                        val hasConnection =
                            NetworkServerAvailable.hasServerConnected(checkHost = "https://google.com")
                        if (hasConnection) {
                            withContext(Dispatchers.Main) {

                            }
                        }
                    }
                }
            }
        }

    }

    fun showErrorDialog(message: String) {
        val foundFragment = findFragmentByTag(CustomDialog::class.java.name)
        if (foundFragment != null && foundFragment.isAdded) return

        val dialog = CustomDialog.newInstance(
            message,
            "cancel",
            "ok",
            true
        )
        dialog.callback = object : CustomDialog.OnDialogCallback {
            override fun onSuccess() {
                dialog.dismiss()
            }

            override fun onCancel() {
                dialog.dismiss()
            }
        }
        dialog.show(supportFragmentManager, CustomDialog::class.java.name)
    }


    abstract fun setupItems()

    override fun onDestroy() {
        super.onDestroy()
    }
}