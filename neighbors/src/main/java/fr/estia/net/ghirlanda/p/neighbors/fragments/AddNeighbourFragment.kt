package fr.estia.net.ghirlanda.p.neighbors.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.Button
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import fr.estia.net.ghirlanda.p.neighbors.NavigationListener
import fr.estia.net.ghirlanda.p.neighbors.R
import fr.estia.net.ghirlanda.p.neighbors.adapters.ListNeighborHandler
import fr.estia.net.ghirlanda.p.neighbors.data.NeighborRepository
import fr.estia.net.ghirlanda.p.neighbors.models.Neighbor

class AddNeighbourFragment :
    Fragment(),
    View.OnClickListener,
    ListNeighborHandler,
    TextWatcher,
    NavigationListener {
    private lateinit var btnSave: Button
    private lateinit var txtNom: TextInputEditText
    private lateinit var txtImage: TextInputEditText
    private lateinit var txtTelephone: TextInputEditText
    private lateinit var txtWebsite: TextInputEditText
    private lateinit var txtAdress: TextInputEditText
    private lateinit var txtMoi: TextInputEditText
    private lateinit var toolbar: Toolbar

    /*Fonction permettant de définir une vue à attacher à un fragment*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_neighbour_fragment, container, false)
        btnSave = view.findViewById(R.id.save)
        txtNom = view.findViewById(R.id.nom)
        txtImage = view.findViewById(R.id.image)
        txtTelephone = view.findViewById(R.id.telephone)
        txtWebsite = view.findViewById(R.id.website)
        txtAdress = view.findViewById(R.id.address)
        txtMoi = view.findViewById(R.id.moi)

        btnSave.setOnClickListener(this)
        btnSave.isEnabled = false

        txtNom.addTextChangedListener(this)
        txtImage.addTextChangedListener(this)
        txtTelephone.addTextChangedListener(this)
        txtWebsite.addTextChangedListener(this)
        txtAdress.addTextChangedListener(this)
        txtMoi.addTextChangedListener(this)

//        toolbar = view.findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
//        updateTitle(R.string.toolbar_add)

        return view
    }

    override fun onClick(v: View?) {
        val newNeighbor = Neighbor(
            NeighborRepository.getInstance().getNeighbours().size.toLong() + 1,
            txtNom.text.toString(),
            txtImage.text.toString(),
            txtAdress.text.toString(),
            txtTelephone.text.toString(),
            txtMoi.text.toString(),
            false,
            txtWebsite.text.toString()
        )
        onAddNeibor(newNeighbor)

        (activity as? NavigationListener)?.showFragment(ListNeighborsFragment())
    }

    override fun onAddNeibor(neighbor: Neighbor) {
        NeighborRepository.getInstance().addNeighbour(neighbor)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        btnSave.isEnabled =
            (!txtNom.text.isNullOrBlank() && !txtImage.text.isNullOrBlank() && !txtAdress.text.isNullOrBlank() && !txtTelephone.text.isNullOrBlank() && !txtMoi.text.isNullOrBlank() && !txtWebsite.text.isNullOrBlank())

        if (txtNom.text.isNullOrBlank()) {
            txtNom.error = getString(R.string.entrer_nom)
        }
        if (!URLUtil.isValidUrl(txtImage.text.toString())) {
            txtImage.error = getString(R.string.lien_valide)
        }
        if (!URLUtil.isValidUrl(txtWebsite.text.toString())) {
            txtWebsite.error = getString(R.string.lien_valide)
        }

        when {
            txtTelephone.text.toString().length != 10 -> {
                txtTelephone.error = getString(R.string.longueur_tel)
            }
            txtTelephone.text.toString().contains("06") -> {
                txtTelephone.error = null
            }
            txtTelephone.text.toString().contains("07") -> {
                txtTelephone.error = null
            }
            else -> {
                txtTelephone.error = getString(R.string.forme_numero)
            }
        }
    }

    override fun showFragment(fragment: Fragment) {
    }

    override fun updateTitle(title: Int) {
    }
}
