package com.fredcodecrafts.lab_week11_a

/*
package com.fredcodecrafts.moodlens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferenceWrapper =
            (application as PreferenceApplication).preferenceWrapper

        val preferenceViewModel = ViewModelProvider(
            this,
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return PreferenceViewModel(preferenceWrapper) as T
                }
            }
        )[PreferenceViewModel::class.java]

        preferenceViewModel.getText().observe(this) {
            findViewById<TextView>(R.id.activity_main_text_view).text = it
        }

        findViewById<Button>(R.id.activity_main_button).setOnClickListener {
            preferenceViewModel.saveText(
                findViewById<EditText>(R.id.activity_main_edit_text).text.toString()
            )
        }
    }
}

 */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val store = (application as SettingsApplication).settingsStore

        val settingsViewModel = ViewModelProvider(
            this,
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return SettingsViewModel(store) as T
                }
            }
        )[SettingsViewModel::class.java]

        settingsViewModel.textLiveData.observe(this) {
            findViewById<TextView>(R.id.activity_main_text_view).text = it
        }

        findViewById<Button>(R.id.activity_main_button).setOnClickListener {
            settingsViewModel.saveText(
                findViewById<EditText>(R.id.activity_main_edit_text).text.toString()
            )
        }
    }
}
