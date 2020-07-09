package com.domain.cats.app.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.domain.cats.app.data.FactsRepository
import com.domain.cats.app.domain.models.Cat
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

// TODO: Faça o disposable.add que fara a limpeza de todos os dados não mais necessários dentro do contêiner.
// TODO: subscribeOn(ioScheduler) especifica que os dados vão passar na thread ioScheduler (request network).
// TODO: observeOn() informa que os dados vão passar na main thread.
// TODO: doOnSubscribe - faça algo quando subscrever algo que é o loading true
// TODO: doFinally() fala que quando o observable terminar de observar ele finalmente faça algo que e tirar o loading.
// TODO: No subscribe acontecera o callback que é mostrar a lista de gatos e caso de erro mostre o erro com o erroException.
// TODO: Alterar o código para utilizar ObservableTransformer para os fluxos de loading e error
// TODO: Qual emitter type (Observable, Flowable, Maybe, Single, Completable) que melhor pode ser utilizado no fluxo reativo do app?
// TODO: Caso seja necessário um diferente do que é utilizado no app, alterar no código para que utilize esse outro emitter type.

class FactsViewModel(
    private val repository: FactsRepository,
    private val ioScheduler: Scheduler,  // Scheduler for IO
    private val mainScheduler: Scheduler // Scheduler for UI/Main
) : ViewModel() {

    private val disposable = CompositeDisposable()

    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Throwable>()
    val catsFacts = MutableLiveData<List<Cat>>()

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }

    fun fetchFacts() {
        // TODO: implement fetchFacts method
        // TODO: after implemented fetchFacts change this to Observable Transformer
    }
}