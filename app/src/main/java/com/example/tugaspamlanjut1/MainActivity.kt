package com.example.tugaspamlanjut1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspamlanjut1.databinding.ActivityMainBinding
import com.example.tugaspamlanjut1.viewmodel.VolumeViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //untuk menghubungkan tampilan dengan kode
    private val viewModel: VolumeViewModel by viewModels() //untuk mengelola data dan logika bisnis dari VolumeViewModel

    //fungsi ini dipanggil saat aktivitas dibuat untuk menginisialisasi tampilan dan logika awal.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //untuk memproses inisialisasi berjalan dengan benar

       //Menghubungkan binding dengan layout XML agar elemen UI bisa diakses langsung dari kode
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //Menetapkan tampilan utama aplikasi

        viewModel.volume.observe(this) { hasil -> //memantau perubahan nilai volume dari ViewModel agar UI selalu diperbarui
            binding.resultTextView.text = "Volume \n$hasil" //Menampilkan hasil perhitungan volume
        }

        // Event saat tombol "Hitung Volume" diklik
        binding.calculateButton.setOnClickListener {
            //Mengambil input panjang, lebar, dan tinggi dari pengguna, lalu mengonversinya ke Double, dengan nilai default 0.0 jika kosong
            val panjang = binding.lengthEditText.text.toString().toDoubleOrNull() ?: 0.0
            val lebar = binding.widthEditText.text.toString().toDoubleOrNull() ?: 0.0
            val tinggi = binding.heightEditText.text.toString().toDoubleOrNull() ?: 0.0
            viewModel.hitungVolume(panjang, lebar, tinggi) //untuk menghitung volume berdasarkan input
        }
    }
}
