package com.example.artspaceapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpacePreview()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpace(){
    ArtSpaceAppTheme {
        ArtSpacePreview()
    }
}

@Composable
fun ArtSpacePreview(){

    val firstImage = R.drawable.iphone_13jpg
    val secondImage = R.drawable.iphone_14
    val thirdImage = R.drawable.iphone_15


var Text by remember {
    mutableStateOf(R.string.iphone_13)
}
    var Desc by remember {
        mutableStateOf(R.string.iphone_13_desc)
    }
    var states by remember {
        mutableStateOf(firstImage)
    }

   Column(
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier.fillMaxSize()
   )
   {
       Column {
           Image(painter = painterResource(states), contentDescription = ""
                )
        Spacer(modifier = Modifier.height(20.dp))
       }
       Column {
           Text(text = stringResource(Text),
               fontSize = 22.sp,
               modifier = Modifier.align(Alignment.CenterHorizontally))
           Spacer(modifier =  Modifier.height(20.dp))
           Text(text = stringResource(Desc),
               fontSize = 18.sp,
               modifier = Modifier
                   .padding(6.dp)
                   .align(Alignment.CenterHorizontally))
       Column(
       ) {
           Spacer(modifier = Modifier.height(30.dp))
           Row {
               Button(onClick = {
                   when(states){
                       thirdImage -> {
                           states = secondImage
                           Text = R.string.iphone_14
                           Desc = R.string.iphone_14_desc
                       }
                       secondImage -> {
                           states = firstImage
                           Text = R.string.iphone_13
                           Desc = R.string.iphone_13_desc
                       }
                       else ->{
                           states = thirdImage
                           Text = R.string.iphone_15
                           Desc = R.string.iphone_15_desc
                       }
                   }
               }) {
                   Text(text = "Previous")

               }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = {
                    when(states){
                        firstImage -> {
                            states = secondImage
                            Text = R.string.iphone_14
                            Desc = R.string.iphone_14_desc
                        }
                        secondImage -> {
                            states = thirdImage
                            Text = R.string.iphone_15
                            Desc = R.string.iphone_15_desc
                        }
                        else ->{
                            states = firstImage
                            Text = R.string.iphone_13
                            Desc = R.string.iphone_13_desc
                        }
                    }

                }) {
                   Text(text = "Next")
               }
           }
       }
       }


   }
}

