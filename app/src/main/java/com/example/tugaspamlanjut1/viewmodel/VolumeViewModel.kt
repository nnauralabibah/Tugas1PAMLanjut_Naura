package com.example.tugaspamlanjut1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VolumeViewModel : ViewModel() {
    //Membuat variabel _volume sebagai MutableLiveData, yang dapat berubah dan mengirim notifikasi saat nilainya diperbarui
    private val _volume = MutableLiveData<Double>()
    val volume: LiveData<Double> get() = _volume

    //Mendeklarasikan fungsi hitungVolume untuk menghitung volume berdasarkan panjang, lebar, dan tinggi yang diberikan
    fun hitungVolume(p: Double, l: Double, t: Double) {
        _volume.value = p * l * t //Mengalikan panjang, lebar, dan tinggi untuk mendapatkan volume
    }
}
