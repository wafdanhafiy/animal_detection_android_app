package com.tugasakhir.animaldetection.ui.detections

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tugasakhir.animaldetection.databinding.FragmentDetectionsBinding
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig

class DetectionsFragment : Fragment() {
    lateinit var imageView: ImageView
    private lateinit var scanViewModel: DetectionsViewModel
    private var _binding: FragmentDetectionsBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val SHOWCASE_ID = "SHOWCASE_ID_1"

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showCaseDetections()
    }

    private fun showCaseDetections() {
        val config = ShowcaseConfig()
        config.delay = 100
        val sequence = MaterialShowcaseSequence(activity, SHOWCASE_ID)

        sequence.setConfig(config)

        sequence.addSequenceItem(
            binding.takeImageShowCase,
            "Tekan 'Mulai Deteksi' untuk mengaktifkan kamera dan melakukan deteksi secara langsung.", "Oke, saya mengerti."
        )

        sequence.start()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        scanViewModel =
            ViewModelProvider(this).get(DetectionsViewModel::class.java)

        _binding = FragmentDetectionsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.camBtn.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.google.com/search?q=TensorFlow")
            startActivity(openURL)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}