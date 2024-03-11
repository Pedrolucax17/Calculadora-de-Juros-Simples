package br.com.fiap.jurossimples.juros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.jurossimples.calculator.calcularJuros
import br.com.fiap.jurossimples.calculator.calcularMontante

class JurosScreenViewModel: ViewModel() {

    private val _capital = MutableLiveData<String>()
    val capital: LiveData<String> = _capital

    private val _taxa = MutableLiveData<String>()
    val taxa: LiveData<String> = _taxa

    private val _tempo = MutableLiveData<String>()
    val tempo: LiveData<String> = _tempo

    private val _juros = MutableLiveData<Double>()
    var jurosState: LiveData<Double> = _juros

    private val _montante = MutableLiveData<Double>()
    var montanteState: LiveData<Double> = _montante

    fun onCapitalChanger(novoCapital: String){
        _capital.value = novoCapital
    }

    fun onTaxaChanger(novaTaxa: String){
        _taxa.value = novaTaxa
    }

    fun onTempoChanger(novoTempo: String){
        _tempo.value = novoTempo
    }

    fun calcularJurosViewModel(){
        _juros.value = calcularJuros(
            capital = _capital.value!!.toDouble(),
            taxa = _taxa.value!!.toDouble(),
            tempo = _tempo.value!!.toDouble()
        )
    }

    fun calcularMontanteViewModel(){
        _montante.value = calcularMontante(
            capital = _capital.value!!.toDouble(),
            juros = _juros.value!!.toDouble()
        )
    }

}