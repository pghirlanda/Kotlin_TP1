package fr.estia.net.ghirlanda.p.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var clickButton: Button
    private lateinit var computeButton: Button
    private lateinit var txtClick: TextView

    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickButton = findViewById(R.id.btn_click_me)
        computeButton = findViewById(R.id.btn_compute)
        txtClick = findViewById(R.id.txt_nb_click)

        clickButton.setOnClickListener {
            nbClick++
            if (nbClick > 4) {
                clickButton.isEnabled = false
            }
            if (nbClick > 0) {
                txtClick.text = "Vous avez cliquez $nbClick fois"
            }
        }

        computeButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
    }
}
