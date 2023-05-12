package com.example.surfspotproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        // Définir la variable listView en référençant l'élément de la vue avec l'identifiant "list_view"
        listView = requireActivity().findViewById<ListView>(R.id.list_view)





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
        val spotAdapter = SpotAdapter(requireContext(), spotList)
        listView.adapter = spotAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}