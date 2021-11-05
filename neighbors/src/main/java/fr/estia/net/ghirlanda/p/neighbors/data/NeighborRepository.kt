package fr.estia.net.ghirlanda.p.neighbors.data

import fr.estia.net.ghirlanda.p.neighbors.data.service.DummyNeighborApiService
import fr.estia.net.ghirlanda.p.neighbors.data.service.NeighborApiService
import fr.estia.net.ghirlanda.p.neighbors.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours

    fun deleteNeighbour(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)

    fun addNeighbour(neighbor: Neighbor) = apiService.createNeighbour(neighbor)

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}
