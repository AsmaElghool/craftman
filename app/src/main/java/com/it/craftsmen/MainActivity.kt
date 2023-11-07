package com.it.craftsmen
/**
 * @setLocalization(fun) -> this is to make app only arabic and set rtl
 * */
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setArabicMainLanguage()
        disableDarkMode()
        configureStatsBar()
    }

    @Suppress("DEPRECATION")
    private fun configureStatsBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        val config = Configuration(resources.configuration)
        resources.updateConfiguration(config, resources.displayMetrics)
    }


    private fun setArabicMainLanguage() {
        val locale = Locale("ar")
        Locale.setDefault(locale)
        val config = baseContext.resources.configuration
        config.setLocale(locale)
        baseContext.createConfigurationContext(config)
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}