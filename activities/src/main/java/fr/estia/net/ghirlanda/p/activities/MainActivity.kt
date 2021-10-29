package fr.estia.net.ghirlanda.p.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.estia.net.ghirlanda.p.activities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClickMe.setOnClickListener {
            nbClick++
            binding.btnClickMe.isEnabled = nbClick <= 4
            if (nbClick > 0) {
                binding.txtNbClick.text = getString(R.string.you_click, nbClick)
            }
        }

        binding.btnCompute.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
    }
}
