package com.domain.cats.app.data

import com.domain.cats.app.data.remote.FactsService
import com.domain.cats.app.domain.models.Cat
import io.reactivex.Observable

// TODO: Retorne o service.fetchFacts() que contem uma lista de FactService com o map.
// TODO: Crie uma variável chamada catResponse e atribua a ela o all de dentro do FactsService
// TODO: Acesse essa lista com o map, pois a mesma contem a função toCat()

interface FactsRepository {
    fun fetchFacts(): Observable<List<Cat>>

    class Impl private constructor(private val service: FactsService) : FactsRepository {

        override fun fetchFacts(): Observable<List<Cat>> {
            // TODO: implement fetchFacts method
        }

        companion object {
            // For Singleton instantiation
            @Volatile private var instance: FactsRepository? = null

            fun getInstance(service: FactsService): FactsRepository =
                instance ?: synchronized(this) {
                    instance ?: Impl(service).also { instance = it }
                }
        }
    }
}
