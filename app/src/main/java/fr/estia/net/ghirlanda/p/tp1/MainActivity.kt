package fr.estia.net.ghirlanda.p.tp1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image_view)
        button = findViewById(R.id.my_button)
        button.setOnClickListener(this)
        loadImage("https://media.istockphoto.com/photos/colored-powder-explosion-on-black-background-picture-id1057506940?k=20&m=1057506940&s=612x612&w=0&h=3j5EA6YFVg3q-laNqTGtLxfCKVR3_o6gcVZZseNaWGk=")
    }

    override fun onClick(view: View?) {
        val link = mutableListOf<String>(
            "https://us.123rf.com/450wm/stockerart/stockerart1712/stockerart171200524/91211628-une-explosion-color%C3%A9e-de-poudre-de-poudre-dans-diff%C3%A9rentes-directions-de-poudre-pour-la-conception-e.jpg?ver=6",
            "https://media.istockphoto.com/photos/explosion-of-colored-powder-on-black-background-picture-id531706796?k=20&m=531706796&s=612x612&w=0&h=pHNUmQXnFqghhZvXcMWJxZJVaE-Cyek8vkX-t1U98_o=",
            "https://media.istockphoto.com/photos/colored-powder-explosion-abstract-closeup-dust-on-backdrop-colorful-picture-id1072093690?k=20&m=1072093690&s=612x612&w=0&h=Ns3WeEm1VrIHhZOmhiGY_fYKvIlbJrVADLqfxyPQVPM=",
            "https://nsm09.casimages.com/img/2020/02/20//20022012264125238916653469.jpg",
            "https://i.pinimg.com/originals/2d/9f/50/2d9f505c5f6c417e22c9f52439b1faca.jpg"
        )
        loadImage(link.random())
        Toast.makeText(this, "You click me", Toast.LENGTH_LONG).show()
    }

    private fun loadImage(url: String) {
        Picasso.get()
            .load(url)
            .resize(500, 500)
            .centerCrop()
            .into(imageView)
    }
}
