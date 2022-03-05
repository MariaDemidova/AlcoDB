package demidova.alcodb.imgConverter

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import demidova.alcodb.App
import demidova.alcodb.databinding.FragmentImgConverterBinding
import demidova.alcodb.view.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ImgConverterFragment : MvpAppCompatFragment(), IImageConverterView, BackButtonListener {

    private var _vb: FragmentImgConverterBinding? = null
    private val vb get() = _vb!!

    private var imageUri: Uri? = null

    private val presenter: ImgConverterPresenter by moxyPresenter {
        ImgConverterPresenter(
            ConverterJpgToPng(requireContext()),
            App.instance.router
        )
    }

    companion object {

        var PERMISSIONS = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentImgConverterBinding.inflate(inflater, container, false).also { _vb = it }.root

    private val permReqLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val granted = permissions.entries.all {
                it.value == true
            }
            if (granted) {
                openActivityForResult()
            }
        }

    private fun takePhoto() {

            if (hasPermissions(activity as Context, PERMISSIONS)) {
                openActivityForResult()
            } else {
                permReqLauncher.launch(
                    PERMISSIONS
                )
        }
    }

    private fun hasPermissions(context: Context, permissions: Array<String>): Boolean = permissions.all {
        ActivityCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun init() {
        hideProgressBar()
        hideErrorBar()
        btnStartConvertDisabled()
        btnAbortConvertDisabled()
        signGetStartedShow()
        signAbortConvertHide()
        signWaitingShow()
        vb.btnImageSelection.setOnClickListener {
            takePhoto()

        }
        vb.btnStartConverting.setOnClickListener {
            imageUri?.let(presenter::startConvertingPressed)
        }
        vb.btnAbort.setOnClickListener {
            presenter.abortConvertImagePressed()
        }
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                imageUri = data?.data
                imageUri?.let { presenter.originalImageSelected(it) }
            }
        }

    private fun openActivityForResult() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/jpg"
        resultLauncher.launch(intent)
    }

    override fun showOriginImage(uri: Uri) {
        vb.imgViewOriginalImg.setImageURI(uri)
    }

    override fun showConvertedImage(uri: Uri) {
        vb.imgViewConvertedImg.setImageURI(uri)
    }

    override fun showProgressBar() {
        vb.progressBar2.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        vb.progressBar2.visibility = View.GONE
    }

    override fun showErrorBar() {
        vb.imgViewConvertedImg.setImageURI(null)
        vb.imgViewErrorSign.visibility = View.VISIBLE
    }

    override fun hideErrorBar() {
        vb.imgViewErrorSign.visibility = View.GONE
    }

    override fun btnStartConvertEnable() {
        vb.btnStartConverting.isEnabled = true
    }

    override fun btnStartConvertDisabled() {
        vb.btnStartConverting.isEnabled = false
    }

    override fun btnAbortConvertEnabled() {
        vb.btnAbort.isEnabled = true
    }

    override fun btnAbortConvertDisabled() {
        vb.btnAbort.isEnabled = false
    }

    override fun signAbortConvertShow() {
        vb.imgViewConvertedImg.setImageURI(null)
        vb.imgViewCancelSign.visibility = View.VISIBLE
    }

    override fun signAbortConvertHide() {
        vb.imgViewCancelSign.visibility = View.GONE
    }

    override fun signGetStartedShow() {
        vb.imgViewGetStartedSign.visibility = View.VISIBLE
    }

    override fun signGetStartedHide() {
        vb.imgViewGetStartedSign.visibility = View.GONE
    }

    override fun signWaitingShow() {
        vb.imgViewConvertedImg.setImageURI(null)
        vb.imgViewWaitingSign.visibility = View.VISIBLE
    }

    override fun signWaitingHide() {
        vb.imgViewWaitingSign.visibility = View.GONE
    }

    override fun backPressed(): Boolean {
        return presenter.backPressed()
    }
}