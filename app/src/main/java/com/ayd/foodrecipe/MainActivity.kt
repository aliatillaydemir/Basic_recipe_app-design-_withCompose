package com.ayd.foodrecipe

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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

    val context = LocalContext.current // for toastMessage

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

                Row(modifier = Modifier.fillMaxWidth()) {

                    Button(  //button1
                      onClick = { Toast.makeText(context, "u like this!", Toast.LENGTH_SHORT).show()},

                            colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.mainColor)
                        ),
                      modifier = Modifier.weight(1f)
                      
                  ) {
                      Texts(content = "Like")
                  }

                    Button(   //button2
                        onClick = { Toast.makeText(context, "Comment!", Toast.LENGTH_SHORT).show()},

                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.mainColor3)
                        ),
                        modifier = Modifier.weight(1f)

                    ) {
                        Texts(content = "Comment")
                    }

                }
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