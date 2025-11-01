package com.example.pmdm

import LoginPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pmdm.PagesC.DetailsPage
import com.example.pmdm.PagesC.ListContend

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DetailsPage()
        }
    }
}

