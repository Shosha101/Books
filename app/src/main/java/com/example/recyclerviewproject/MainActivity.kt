package com.example.recyclerviewproject


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)


        //binding.name="Hiii"


        val users = listOf(
            User("Ahmed Mohamed", "by Jaki Chan", R.drawable.blood),
            User("Mahmoud Amr", "by Ramez Galal", R.drawable.humming),
            User("Ali Ahmed", "by Ali Mohsan", R.drawable.nostra),
            User("Ibrahim Shosha", "by Charles Daken", R.drawable.solitude),
            User("Ahmed Shosha", "by Shosha", R.drawable.angels),
            User("Ahmed Shosha", "by Mo Salah", R.drawable.spirits),
            User("Ahmed Shosha", "by Samira Said", R.drawable.sword),
            // Add more users with corresponding images
        )




        val userAdapter = UserAdapter(users)

       // binding.rvUsers.layoutManager=LinearLayoutManager(this)
        binding.rvUsers.adapter=userAdapter


        binding.toolbar.materialToolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.notification -> {
                    Toast.makeText(this,R.string.notification, Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }


        binding.toolbar.materialToolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()




        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.id_reviews -> {
                    Toast.makeText(this, R.string.review_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                R.id.id_favorite -> {
                    Toast.makeText(this, R.string.favorite_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }
                R.id.id_search -> {
                    Toast.makeText(this, R.string.search_clicked, Toast.LENGTH_SHORT).show()
                    binding.drawerLayout.close()
                    true
                }

                else -> false
            }
        }

}
    }
}