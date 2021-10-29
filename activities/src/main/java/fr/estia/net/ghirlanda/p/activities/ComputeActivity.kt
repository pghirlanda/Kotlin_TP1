package fr.estia.net.ghirlanda.p.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity(), View.OnClickListener, TextWatcher {
    private lateinit var champ1: EditText
    private lateinit var champ2: EditText
    private lateinit var resultat: TextView
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)

        champ1 = findViewById(R.id.field_1)
        champ2 = findViewById(R.id.field_2)
        resultat = findViewById(R.id.resultat)
        btn = findViewById(R.id.btn_calculer)
        btn.setOnClickListener(this)
        btn.isEnabled = false

        champ1.addTextChangedListener(this)
        champ2.addTextChangedListener(this)
    }

    override fun onClick(v: View?) {
        if (champ1.text.isNotBlank() && champ2.text.isNotBlank()) {
            resultat.text =
                (champ1.text.toString().toDouble() + champ2.text.toString().toDouble()).toString()
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        btn.isEnabled = champ1.text.isNotBlank() && champ2.text.isNotBlank()
    }
}
