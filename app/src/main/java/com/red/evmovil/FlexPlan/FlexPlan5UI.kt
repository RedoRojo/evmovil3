package com.red.evmovil.FlexPlan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FlexPlanUI() {
    val coralColor = Color(0xFFFF6B6B)
    val lightCoralColor = Color(0xFFFFE5E5)
    val grayTextColor = Color(0xFF666666)
    val darkGrayTextColor = Color(0xFF333333)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header Section
        Text(
            text = "Nuestros planes móviles",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = coralColor,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "La mejor cobertura, increíbles beneficios\ny un compromiso con el planeta.",
            fontSize = 16.sp,
            color = grayTextColor,
            textAlign = TextAlign.Center,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Plan Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Plan Title
                Text(
                    text = "Plan FLEX 5",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = coralColor
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Price Section
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Antes ",
                        fontSize = 14.sp,
                        color = grayTextColor
                    )
                    Text(
                        text = "$270",
                        fontSize = 16.sp,
                        color = grayTextColor,
                        textDecoration = TextDecoration.LineThrough
                    )
                    Text(
                        text = " /mes",
                        fontSize = 14.sp,
                        color = grayTextColor
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Ahora ",
                        fontSize = 14.sp,
                        color = grayTextColor
                    )
                    Text(
                        text = "$199",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = darkGrayTextColor
                    )
                    Text(
                        text = " /mes",
                        fontSize = 14.sp,
                        color = grayTextColor
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "5GB",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = grayTextColor
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Features List
                FeatureItem(
                    icon = Icons.Default.Phone,
                    text = "Llamadas y SMS\nilimitados",
                    iconColor = coralColor
                )

                Spacer(modifier = Modifier.height(16.dp))

                FeatureItem(
                    icon = Icons.Default.Wifi,
                    text = "Hotspot. Comparte tus\ndatos",
                    iconColor = coralColor
                )

                Spacer(modifier = Modifier.height(16.dp))

                FeatureItem(
                    icon = Icons.Default.Share,
                    text = "Redes Sociales ilimitadas\nincluidas",
                    iconColor = coralColor
                )

                Spacer(modifier = Modifier.height(16.dp))

                FeatureItem(
                    icon = Icons.Default.Apps,
                    text = "Arma tu plan con más\napps ilimitadas",
                    iconColor = coralColor
                )

                Spacer(modifier = Modifier.height(16.dp))

                FeatureItem(
                    icon = Icons.Default.Eco,
                    text = "CO2 Negativo",
                    iconColor = Color(0xFF4CAF50)
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Social Media Icons
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SocialMediaIcon(
                        icon = Icons.Default.Phone,
                        backgroundColor = Color.Black
                    )
                    SocialMediaIcon(
                        icon = Icons.Default.PlayArrow,
                        backgroundColor = Color.Black
                    )
                    SocialMediaIcon(
                        icon = Icons.Default.Facebook,
                        backgroundColor = Color(0xFF1877F2)
                    )
                    SocialMediaIcon(
                        icon = Icons.Default.Close, // X (Twitter)
                        backgroundColor = Color.Black
                    )
                    SocialMediaIcon(
                        icon = Icons.Default.CameraAlt,
                        backgroundColor = Color(0xFFE4405F)
                    )
                    SocialMediaIcon(
                        icon = Icons.Default.VideoLibrary,
                        backgroundColor = Color(0xFF25D366)
                    )
                    SocialMediaIcon(
                        icon = Icons.Default.MusicNote,
                        backgroundColor = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // CTA Button
                Button(
                    onClick = { /* Handle click */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = coralColor
                    ),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Text(
                        text = "Quiero este plan",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }
            }
        }

        // WhatsApp floating button space
        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            FloatingActionButton(
                onClick = { /* Handle WhatsApp click */ },
                containerColor = Color(0xFF25D366),
                modifier = Modifier.size(56.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "WhatsApp",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun FeatureItem(
    icon: ImageVector,
    text: String,
    iconColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(0xFF333333),
            lineHeight = 20.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun SocialMediaIcon(
    icon: ImageVector,
    backgroundColor: Color
) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FlexPlan5UI() {
    MaterialTheme {
        FlexPlanUI()
    }
}