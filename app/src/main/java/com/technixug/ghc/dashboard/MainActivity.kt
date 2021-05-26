package com.technixug.ghc.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.technixug.ghc.*
import com.technixug.ghc.addeditfarmer.EditFarmer
import com.technixug.ghc.farmerinfo.FarmerBioData


class MainActivity : AppCompatActivity() {

    //declarations
    private lateinit var gridView: GridView
    private var ItemNames = arrayOf("Admin Center", "Farmers Bio", "Security Center", "Visits MGT")
            private var ItemImages = intArrayOf(
                R.drawable.app_icons_examinations,
                R.drawable.app_icons_accounts,
                R.drawable.app_icons_security,
                R.drawable.app_icons_examinations
            )
    //main oncreate
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Dashboard"

        gridView = findViewById(R.id.gvListItem)
        val mainAdapter = MainAdapter(this@MainActivity, ItemNames, ItemImages)
        gridView.adapter = mainAdapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
//
            Toast.makeText(this@MainActivity, "" + position, Toast.LENGTH_SHORT).show()
            //Intent i = new Intent(nclApp2.this, Screen2.class);
            var myIntent: Intent? = null
            if (position == 0) {
                myIntent = Intent(this, EditFarmer::class.java)
//                myIntent.putExtra("name of farmer",ItemNames)
            }
            if (position == 1) {
                myIntent = Intent(this, FarmerBioData::class.java)

            }
            if (position == 2) {
//                myIntent = Intent(this, Login::class.java)
                Toast.makeText(this,"Security center for admin only",Toast.LENGTH_SHORT).show()
            }
            if (position == 3) {
                myIntent = Intent(this, GhcVisits::class.java)
            }
            startActivity(myIntent)
        }

        //intent
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.log_out->{
                //TODO Log out logic
                val intent = Intent(this,Login::class.java)
                startActivity(intent)
            }
            R.id.help->{
                //TODO
            }
            else ->{
                return super.onOptionsItemSelected(item)
            }
        }
        return true
    }
}