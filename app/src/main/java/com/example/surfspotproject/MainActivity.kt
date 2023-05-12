package com.example.surfspotproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.surfspotproject.databinding.ActivityMainBinding
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        // Définir la variable listView en référençant l'élément de la vue avec l'identifiant "list_view"
        val listView = findViewById<ListView>(R.id.list_view)

        // Créer la liste de spots
        val spotList = listOf(
            Spot("Spot 1", "Lieu 1", R.drawable.spot1),
            Spot("Spot 2", "Lieu 2", R.drawable.spot2),
            Spot("Spot 3", "Lieu 3", R.drawable.spot3)
        )

        // Créer une instance de SpotAdapter et l'attacher à ListView
        val spotAdapter = SpotAdapter(this, spotList)
        listView.adapter = spotAdapter

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.favorite -> replaceFragment(Favorite())
                R.id.settings -> replaceFragment(Settings())

                else ->{



                }

            }

            true

        }

    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}