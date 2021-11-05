package fr.estia.net.ghirlanda.p.neighbors.adapters

import fr.estia.net.ghirlanda.p.neighbors.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeibor(neighbor: Neighbor) {
    }

    fun onAddNeibor(neighbor: Neighbor) {
    }
}
