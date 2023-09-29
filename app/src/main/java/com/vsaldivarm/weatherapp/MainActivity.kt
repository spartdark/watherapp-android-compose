package com.vsaldivarm.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vsaldivarm.weatherapp.ui.theme.DarkBlue
import com.vsaldivarm.weatherapp.ui.theme.LightGray
import com.vsaldivarm.weatherapp.ui.theme.VeryLightGray
import com.vsaldivarm.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherPage()
                }
            }
        }
    }
}

@Composable
fun WeatherPage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 64.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderImage()
        MainInfo()
        InfoTable()
    }

}


@Composable
fun HeaderImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_couple), contentDescription = "Header image",
        modifier = Modifier.width(200.dp)
    )
}

@Composable
fun MainInfo() {
    Column(
        modifier = Modifier.padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "11°", fontWeight = FontWeight.Bold, fontSize = 48.sp, color = DarkBlue)
        Text(
            text = "Ciudad de Mexico", fontWeight = FontWeight.Medium, fontSize = 20.sp,
            color = DarkBlue,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Mayormente soleado \n Máxima: 25° Mínima: 13°", color = Color.Gray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 24.dp)
        )
    }
}

@Composable
fun InfoTable() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(VeryLightGray)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            InfoItem(
                iconRes = R.drawable.ic_humidity,
                tittle = "Humidity",
                subtittle = "85%",
                modifier = Modifier.weight(
                    1f
                )
            )
            InfoItem(
                iconRes = R.drawable.ic_sun_full,
                tittle = "UV Index",
                subtittle = "2 de 10",
                modifier = Modifier.weight(
                    1f
                )
            )

        }
        Divider(color = LightGray)
        Row(modifier = Modifier.padding(16.dp)) {
            InfoItem(
                iconRes = R.drawable.ic_sun_half,
                tittle = "Sunrise",
                subtittle = "7:30 AM",
                modifier = Modifier.weight(
                    1f
                )
            )
            InfoItem(
                iconRes = R.drawable.ic_sun_half,
                tittle = "Sunset",
                subtittle = "4:28 PM",
                modifier = Modifier.weight(
                    1f
                )
            )

        }
    }
}

@Composable
fun InfoItem(@DrawableRes iconRes: Int, tittle: String, subtittle: String, modifier: Modifier) {
    Row(modifier = modifier) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            Modifier
                .padding(end = 8.dp)
                .width(40.dp)
        )
        Column {
            Text(text = tittle, color = Color.Gray)
            Text(text = subtittle, color = DarkBlue, fontWeight = FontWeight.Bold)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppTheme {
        WeatherPage()
    }
}