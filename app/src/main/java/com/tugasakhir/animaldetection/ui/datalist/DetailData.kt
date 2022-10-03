package com.tugasakhir.animaldetection.ui.datalist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tugasakhir.animaldetection.R
import com.tugasakhir.animaldetection.data.source.local.entity.DataEntity
import com.tugasakhir.animaldetection.databinding.ActivityDataDetailBinding
import com.bumptech.glide.Glide

class DetailData : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    lateinit var binding: ActivityDataDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataDetailBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)
        title = getString(R.string.title_detail_data)

        val detailData = intent.getParcelableExtra<DataEntity>(EXTRA_DATA)
        populateDataList(detailData)
    }

    private fun populateDataList(data: DataEntity?) {
        data?.let {
            binding.titleData.text = data.title
            binding.deskripsi1Content.text = data.deskripsi1
            binding.deskripsi2Content.text = data.deskripsi2
            binding.deskripsi3Content.text = data.deskripsi3

            Glide.with(this)
                .load(data.imgPath)
                .into(binding.imageView)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
