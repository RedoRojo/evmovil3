package com.red.evmovil.FlexPlan
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FlexPlan5UI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Nuestros planes móviles",
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFF6F61))
        )
        Text(
            "La mejor cobertura, increíbles beneficios y un compromiso con el planeta.",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Plan FLEX 5", style = MaterialTheme.typography.headlineSmall)

                Text(
                    text = "$270",
                    style = TextStyle(
                        textDecoration = TextDecoration.LineThrough,
                        fontSize = 18.sp
                    )
                )
                Text(
                    text = "$199",
                    style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
                )
                Text("5GB", fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(8.dp))

                val benefits = listOf(
                    "Llamadas y SMS ilimitados",
                    "Hotspot. Comparte tus datos",
                    "Redes Sociales ilimitadas incluidas",
                    "Arma tu plan con más apps ilimitadas",
                    "CO2 Negativo"
                )

                benefits.forEach {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null, tint = Color.Red)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(it)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* Acción para elegir plan */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Quiero este plan")
                }

                Spacer(modifier = Modifier.height(16.dp))

                IconButton(onClick = {
                    // Acción de WhatsApp
                }) {
                    Text("📱") // Puedes usar un ícono real si lo importas
                }
            }
        }
    }
}
