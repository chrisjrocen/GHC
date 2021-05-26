package com.technixug.ghc.farmerinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.technixug.ghc.R

class FarmerBioData : AppCompatActivity() {


    private lateinit var listView: ListView
    private var ItemNames = arrayOf("Farmer one", "Farmer two", "Farmer three", "Farmer four")
    private var ItemImages = intArrayOf(
            R.drawable.placeholder,
            R.drawable.placeholder,
            R.drawable.placeholder,
            R.drawable.placeholder
    )
    //private var

    //main oncreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_farmer_bio_data)
        title = "Farmers List"


        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        val adapter = CustomAdapter(ItemNames)
        recyclerView.adapter = adapter


        //list view working below


//        listView = findViewById(R.id.lvListItem)
//        val farmerAdapter = FarmerAdapter(this@FarmerBioData, ItemNames, ItemImages)
//        listView.adapter = farmerAdapter
//
//
//        val btnMore = findViewById<Button>(R.id.btnMore)
//        val btnEdit = findViewById<Button>(R.id.btnEdit)
//
//        listView.setOnItemClickListener { parent, view, position, id ->
//            val element = farmerAdapter.getItemId(position).toString() // The item that was clicked
//            Toast.makeText(this,element,Toast.LENGTH_SHORT).show()
//            val myIntent: Intent?
//
//            myIntent = Intent(this, EditFarmer::class.java)
//            myIntent.putExtra("name of farmer",ItemNames)
//            myIntent.putExtra("farmer position",element)
//
//            startActivity(intent)
//        }
//
//    }

    }


    class CustomAdapter(private val dataSet: Array<String>) :
            RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.tvItemin)

            init {
                // Define click listener for the ViewHolder's View.
            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.text_row_item, viewGroup, false)

            return ViewHolder(view)
        }


        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.textView.text = dataSet[position]
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size

    }

}
