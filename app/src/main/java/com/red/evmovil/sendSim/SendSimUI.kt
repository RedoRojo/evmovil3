package com.red.evmovil.sendSim

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun PlanOrderUI() {
    val coralColor = Color(0xFFFF6B6B)
    val grayTextColor = Color(0xFF666666)
    val darkGrayTextColor = Color(0xFF333333)

    var referencePhone by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }

    // Estado del mapa
    var selectedLocation by remember { mutableStateOf<LatLng?>(null) }
    val defaultLocation = LatLng(-17.37166, -66.14409)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(defaultLocation, 15f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        // Header Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(coralColor)
                .padding(vertical = 24.dp, horizontal = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Elegiste un plan",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "Configurar entrega",
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }


            }
        }

        // Content Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            // Title
            Text(
                text = "¿Dónde enviamos tu SIM?",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = coralColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Completa los datos para recibir tu nueva SIM\nen la ubicación que prefieras.",
                fontSize = 16.sp,
                color = grayTextColor,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Form Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
                    // Reference Phone Field
                    Text(
                        text = "Teléfono de referencia *",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = darkGrayTextColor,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    OutlinedTextField(
                        value = referencePhone,
                        onValueChange = { referencePhone = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "Ej: +52 55 1234 5678",
                                color = grayTextColor
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = null,
                                tint = coralColor
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = coralColor,
                            cursorColor = coralColor,
                            focusedLabelColor = coralColor
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Location Section Title
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = coralColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Ubicación de entrega",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = darkGrayTextColor
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Google Map
                    GoogleMap(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        cameraPositionState = cameraPositionState,
                        onMapClick = { latLng ->
                            selectedLocation = latLng
                            latitude = "%.6f".format(latLng.latitude)
                            longitude = "%.6f".format(latLng.longitude)
                        }
                    ) {
                        selectedLocation?.let { location ->
                            Marker(
                                state = MarkerState(position = location),
                                title = "Ubicación de entrega",
                                snippet = "Lat: %.4f, Lng: %.4f".format(location.latitude, location.longitude)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Coordinates Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // Latitude Field
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Latitud *",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = darkGrayTextColor,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            OutlinedTextField(
                                value = latitude,
                                onValueChange = { latitude = it },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(
                                        text = "19.4326",
                                        color = grayTextColor
                                    )
                                },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = coralColor,
                                    cursorColor = coralColor,
                                    focusedLabelColor = coralColor
                                ),
                                shape = RoundedCornerShape(12.dp)
                            )
                        }

                        // Longitude Field
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Longitud *",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = darkGrayTextColor,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            OutlinedTextField(
                                value = longitude,
                                onValueChange = { longitude = it },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(
                                        text = "-99.1332",
                                        color = grayTextColor
                                    )
                                },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = coralColor,
                                    cursorColor = coralColor,
                                    focusedLabelColor = coralColor
                                ),
                                shape = RoundedCornerShape(12.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Helper Text
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = coralColor,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Las coordenadas se actualizarán automáticamente al seleccionar en el mapa",
                            fontSize = 12.sp,
                            color = grayTextColor,
                            lineHeight = 16.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Continue Button
            Button(
                onClick = { /* Handle continue */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                enabled = referencePhone.isNotEmpty() && latitude.isNotEmpty() && longitude.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = coralColor,
                    disabledContainerColor = grayTextColor.copy(alpha = 0.3f)
                ),
                shape = RoundedCornerShape(28.dp)
            ) {
                Text(
                    text = "Continuar",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Required fields note
            Text(
                text = "* Campos obligatorios",
                fontSize = 12.sp,
                color = grayTextColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun SendSimUI() {
    MaterialTheme {
        PlanOrderUI()
    }
}