package com.example.surfspotproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.surfspotproject.databinding.ActivityMainBinding
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        // Définir la variable listView en référençant l'élément de la vue avec l'identifiant "list_view"
        /*listView = findViewById<ListView>(R.id.list_view)

        // Créer la liste de spots
        val names = listOf("Bells Beach", "Uluwatu", "Benzaï pipeline", "Nazaré", "Biarritz", "Barra de la Cruz", "CloudBreak", "Rincon")
        val locations = listOf("Australie", "Indonésie", "Hawaï", "Portugal", "France", "Mexique", "Îles des Fidji", "Puerto Rico")
        val images = listOf(R.drawable.`spot2`, R.drawable.spot2, R.drawable.spot2, R.drawable.`spot2`, R.drawable.`spot2`, R.drawable.spot2, R.drawable.spot2, R.drawable.`spot2`)

        val spotList = mutableListOf<Spot>()
        for (i in 0 until names.size) {
            val spot = Spot(names[i], locations[i], images[i])
            spotList.add(spot)
        }



        // Créer une instance de SpotAdapter et l'attacher à ListView
        val spotAdapter = SpotAdapter(this, spotList)
        listView.adapter = spotAdapter*/

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