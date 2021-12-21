package com.ayd.foodrecipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ayd.foodrecipe.ui.theme.FoodRecipeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodRecipeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainMethod()
                }
            }
        }
    }
}

@Composable
fun MainMethod() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = "Recipe")},
                backgroundColor = colorResource(id = R.color.mainColor)
            )

        }, content = {

            Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
            ) {
               Image(painter = painterResource(id =R.drawable.pannacotta), contentDescription ="")

            }
        }
    )

}

@Composable
fun Texts(content : String){
    Text(text = content)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodRecipeTheme {
        MainMethod()
    }
}