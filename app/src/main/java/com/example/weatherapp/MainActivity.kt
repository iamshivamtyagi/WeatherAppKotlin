package com.example.weatherapp

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    val CITY: String = "New Delhi,In"
    val API: String = "4ad88698f0a22dc27de58f2ff0489f1d"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainTask().execute()
    }

    inner class mainTask() : AsyncTask<String, Void, String>() {

        override fun onPreExecute() {
            super.onPreExecute()

            // Showing progress bar & main design hidden
            loader.visibility = View.VISIBLE
            mainContainer.visibility = View.GONE
            errorText.visibility = View.GONE

        }

        override fun doInBackground(vararg params: String?): String? {
            
            return try {
                URL("http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=$API").readText(
                    Charsets.UTF_8
                )
            } catch (e: Exception) {
                null
            }
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            try {
                // Extracting JSON returns from API
            } catch (e: Exception) {

            }
        }
    }

}
