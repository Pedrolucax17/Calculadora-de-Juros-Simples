package br.com.fiap.jurossimples.juros

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.jurossimples.calculator.calcularJuros
import br.com.fiap.jurossimples.calculator.calcularMontante
import br.com.fiap.jurossimples.components.Inbox
import br.com.fiap.jurossimples.components.ResultCard

@Composable
fun JurosScreen(jurosScreenViewModel: JurosScreenViewModel) {

    val capital by jurosScreenViewModel.capital.observeAsState(initial = "")
    val taxa by jurosScreenViewModel.taxa.observeAsState(initial = "")
    val tempo by jurosScreenViewModel.tempo.observeAsState(initial = "")
    val juros by jurosScreenViewModel.jurosState.observeAsState(initial = 0.0)
    val montante by jurosScreenViewModel.montanteState.observeAsState(initial = 0.0)
    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        Column {
            Text(
                text = "Cálculo de Juros Simples",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))

            Card (
                modifier = Modifier.fillMaxWidth()
            ){
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Dados do Investimento",
                        fontWeight = FontWeight.Bold
                    )

                    Inbox(
                        value = capital,
                        placeHolder = "Quanto deseja investir",
                        label = "Valor do Investimento",
                        keyBoardType = KeyboardType.Number,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        uptadeValue = {
                            jurosScreenViewModel.onCapitalChanger(it)
                        }
                    )

                    Inbox(
                        value = taxa,
                        placeHolder = "Qual a taxa de juros mensal?",
                        label = "Taxa de juros mensal",
                        keyBoardType = KeyboardType.Number,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        uptadeValue = {
                            jurosScreenViewModel.onTaxaChanger(it)
                        }
                    )

                    Inbox(
                        value = tempo,
                        placeHolder = "Qual o tempo em meses?",
                        label = "Período em meses",
                        keyBoardType = KeyboardType.Number,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        uptadeValue = {
                            jurosScreenViewModel.onTempoChanger(it)
                        }
                    )

                    Button(
                        onClick = {
                            jurosScreenViewModel.calcularJurosViewModel()
                            jurosScreenViewModel.calcularMontanteViewModel()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp)
                    ) {
                        Text(text = "Calcular")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            ResultCard(juros = juros, montante = montante)
        }
    }
}
