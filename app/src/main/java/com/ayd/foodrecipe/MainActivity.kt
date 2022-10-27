package com.ayd.foodrecipe

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    val scrollState = rememberScrollState()

    // Smooth scroll to specified pixels on first composition
    //LaunchedEffect(Unit) { scrollState.animateScrollTo(10000) }

    val context = LocalContext.current // for toastMessage

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = "Recipe App")},
                backgroundColor = colorResource(id = R.color.mainColor)
            )

        }, content = {

            Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
                               .verticalScroll(scrollState) //for scroll
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
            
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)) {
                    Text(text = "Panna Cotta",
                        color = colorResource(id = R.color.mainColor3),
                        fontSize = 30.sp)
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Texts(content = "Milk dessert")
                        Texts(content = "22/12/2021")
                    }
                }

                Text(text = "Step 1\n" +
                        "Pour milk into a small bowl, and stir in the gelatin powder. Set aside.\n" +
                        "\n" +
                        "Step 2\n" +
                        "In a saucepan, stir together the heavy cream and sugar, and set over medium heat. Bring to a full boil, watching carefully, as the cream will quickly rise to the top of the pan. Pour the gelatin and milk into the cream, stirring until completely dissolved. Cook for one minute, stirring constantly. Remove from heat, stir in the vanilla and pour into six individual ramekin dishes.\n" +
                        "\n" +
                        "Step 3\n" +
                        "Cool the ramekins uncovered at room temperature. When cool, cover with plastic wrap, and refrigerate for at least 4 hours, but preferably overnight before serving.",
                    modifier = Modifier.padding(all = 10.dp),
                    textAlign = TextAlign.Center)
            
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