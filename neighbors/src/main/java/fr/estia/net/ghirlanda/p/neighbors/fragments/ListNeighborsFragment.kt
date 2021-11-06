package fr.estia.net.ghirlanda.p.neighbors.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import fr.estia.net.ghirlanda.p.neighbors.NavigationListener
import fr.estia.net.ghirlanda.p.neighbors.R
import fr.estia.net.ghirlanda.p.neighbors.adapters.ListNeighborHandler
import fr.estia.net.ghirlanda.p.neighbors.adapters.ListNeighborsAdapter
import fr.estia.net.ghirlanda.p.neighbors.data.NeighborRepository
import fr.estia.net.ghirlanda.p.neighbors.models.Neighbor

class ListNeighborsFragment :
    Fragment(),
    ListNeighborHandler,
    View.OnClickListener,
    NavigationListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnAdd: FloatingActionButton

    /*Fonction permettant de définir une vue à attacher à un fragment*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        (activity as? NavigationListener)?.updateTitle(R.string.toolbar_liste)

        btnAdd = view.findViewById(R.id.btn_add_neighbor)
        btnAdd.setOnClickListener(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }

    override fun onDeleteNeibor(neighbor: Neighbor) {
        val builder = AlertDialog.Builder(this.context)
        builder.setTitle(getString(R.string.confirmation))
        builder.setMessage(getString(R.string.supprimer_voisin))
        builder.setPositiveButton(
            getString(R.string.oui)
        ) { _, _ ->
            NeighborRepository.getInstance().deleteNeighbour(neighbor)
            refreshList()
        }
        builder.setNegativeButton(
            getString(R.string.non)
        ) { _, _ -> }
        builder.show()
    }

    private fun refreshList() {
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }

    override fun onClick(v: View?) {
        (activity as? NavigationListener)?.showFragment(AddNeighbourFragment())
    }

    override fun showFragment(fragment: Fragment) {
    }

    override fun updateTitle(title: Int) {
    }
}
