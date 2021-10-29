package fr.estia.net.ghirlanda.p.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import fr.estia.net.ghirlanda.p.activities.databinding.ComputeActivityBinding

class ComputeActivity : AppCompatActivity(), View.OnClickListener, TextWatcher {
    private lateinit var binding: ComputeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ComputeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            btnCalculer.setOnClickListener(this@ComputeActivity)
            field1.addTextChangedListener(this@ComputeActivity)
            field2.addTextChangedListener(this@ComputeActivity)
            btnCalculer.isEnabled = false
        }
    }

    override fun onClick(v: View?) {
        if (binding.field1.text.isNotBlank() && binding.field2.text.isNotBlank()) {
            binding.resultat.text =
                (
                    binding.field1.text.toString().toDouble() + binding.field2.text.toString()
                        .toDouble()
                    ).toString()
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        binding.btnCalculer.isEnabled =
            binding.field1.text.isNotBlank() && binding.field2.text.isNotBlank()
    }
}
