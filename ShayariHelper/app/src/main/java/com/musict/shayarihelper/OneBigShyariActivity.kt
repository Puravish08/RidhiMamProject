package com.musict.shayarihelper

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.musict.shayarihelper.databinding.ActivityOneBigShyariBinding
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle


class OneBigShyariActivity : AppCompatActivity() {
    lateinit var disbinding: ActivityOneBigShyariBinding

//     lateinit var imageView : ImageView
//
//    private lateinit var  url : String


    val REQUEST_IMAGE_GALLERY = 100
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        disbinding = ActivityOneBigShyariBinding.inflate(layoutInflater)
        setContentView(disbinding.root)


//
//        val url: String? = intent.getStringExtra("image")
//
//
//
//        PRDownloader.initialize(getApplicationContext());


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.onebigshyari)
        }
        displayshayari()


    }


    @SuppressLint("ServiceCast", "ResourceType")
    private fun displayshayari() {


//        imageView = findViewById(R.id.imglikefv)


        var shayari: String? = intent.getStringExtra("shayari")
        disbinding.txtshayari.text = shayari



        disbinding.share.setOnClickListener {
            val p = Intent(Intent.ACTION_SEND)
            p.type = "text/plan"

            p.putExtra(Intent.EXTRA_SUBJECT, "Share")
            p.putExtra(Intent.EXTRA_TEXT, " " + shayari)
            startActivity(Intent.createChooser(p, "Share"))
        }

        disbinding.backme.setOnClickListener {

            onBackPressed()
        }


        disbinding.copyimg.setOnClickListener {


            val clipboard: ClipboardManager =
                getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("label", shayari)
            clipboard.setPrimaryClip(clip)
            MotionToast.darkColorToast(this, "Copy Success!", " Quotes Copy Successfully!",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helvetica_regular)
            )

        }


//
//        disbinding.imgdowlond.setOnClickListener {
//
//
//            checkPermission()
//
//
//        }

        disbinding.imgdowlond.setOnClickListener {


        }



        disbinding.add.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"

            val pickImageIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(pickImageIntent, REQUEST_IMAGE_GALLERY)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == REQUEST_IMAGE_GALLERY) {
            imageUri = data?.data
            disbinding.imgshow.setImageURI(imageUri)
        }
    }


//    private fun checkPermission() {
//
//        Dexter.withContext(this)
//            .withPermissions(
//                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                android.Manifest.permission.READ_EXTERNAL_STORAGE,
//                android.Manifest.permission.INTERNET
//
//            ).withListener(object : MultiplePermissionsListener {
//                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
//                    if (report.areAllPermissionsGranted()){
//                        downloadImage()
//                    }
//                    else
//                    {
//                        Toast.makeText(this, "Please allow all permission", Toast.LENGTH_SHORT).show()
//                    }
//
//
//
//
//                }
//
//
//
//
//                override fun onPermissionRationaleShouldBeShown(permissions: List<PermissionRequest?>?, token: PermissionToken?) { /* ... */
//
//
//
//                }
//            }).check()
//    }

//    private fun downloadImage() {
//
//
//
//        val file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
//
//
//
//        PRDownloader.download(url, file.path, fileName)
//            .build()
//            .setOnStartOrResumeListener(object : OnStartOrResumeListener() {
//                fun onStartOrResume() {}
//            })
//            .setOnPauseListener(object : OnPauseListener() {
//                fun onPause() {}
//            })
//            .setOnCancelListener(object : SearchManager.OnCancelListener() {
//                fun onCancel() {}
//            })
//            .setOnProgressListener(object : OnProgressListener() {
//                fun onProgress(progress: org.gradle.internal.operations.trace.BuildOperationRecord.Progress?) {}
//            })
//            .start(object : OnDownloadListener() {
//                fun onDownloadComplete() {}
//                fun onError(error: Error?) {}
//            })
//
//
//    }


}




