package com.example.tapandroidform

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.Preference
import com.chillibits.simplesettings.core.SimpleSettings
import com.chillibits.simplesettings.core.SimpleSettingsConfig

class MainActivity : AppCompatActivity(),SimpleSettingsConfig.PreferenceCallback  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val configuration = SimpleSettingsConfig.Builder()
            .setActivityTitle("Configuration")
            .setPreferenceCallback(this)
            .displayHomeAsUpEnabled(false)
            .build()
        SimpleSettings(this, configuration).show(R.xml.preferences)
    }
    override fun onPreferenceClick(context: Context, key: String): Preference.OnPreferenceClickListener? {
        return when(key) {
            "dialog_preference" -> Preference.OnPreferenceClickListener {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                finish()
                startActivity(intent)

                true
            }

            else -> super.onPreferenceClick(context, key)
        }
    }
}