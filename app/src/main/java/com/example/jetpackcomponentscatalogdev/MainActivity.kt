package com.example.jetpackcomponentscatalogdev

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalogdev.ui.theme.CheckInfo
import com.example.jetpackcomponentscatalogdev.ui.theme.JetpackComponentsCatalogDevTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogDevTheme {
                // A surface container using the 'background' color from the theme
                var selected by remember { mutableStateOf("Aris")}
                var show by remember { mutableStateOf(false) }
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
//                    MyBox("Android")
//                    MyStateExample()
//                    MyText()
//                    Column() {
//                        MyTextFielOutlined()
//                    }
//                    var myText by remember { mutableStateOf("hola") }
//                    MyTextfield(myText) {myText = it}
//                    MyButtonExample()
//                    MyIcon()
//                    MyProgressAdvance()
//                    MyCheckBox()
//                    val myOptions = getOptions(listOf("Java", "Kotlin", "Python"))
//                    Column() {
//                        MyTriStatusCheckBox()
//                        myOptions.forEach {
//                            MyCheckBoxWithTextCompleted(it)
//                        }
//                    }

                    Box( Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                        MyRadioButtonList(selected) { selected = it }
//                        MyCard()
//                        MyDropDownMenu()
//                        MyBasicSlider()
//                        MyAdvanceSlider()
//                        MyRangeSlider()
                        Button(onClick = { show = true }) {
                            Text(text = "Mostar dialogo")
                        }
//                        MyAlertDialog(show = show, onDismiss = { show = false }, onConfirm = { Log.i("airs", "")})
//                        MySimpleCustomDialog(show = show, onDismiss = { show = false })
                        MyCustomDialog(show = show, onDismiss = { show = false })
//                        MyConfirmationDialog(show = show, onDismiss = { show = false })
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComponentsCatalogDevTheme {
//        MyBox("Android")
//        MyColumn()
//        MyRow()
//        MyComplexLayout()
//        MyStateExample()
//        MyText()
//        MyTextFielOutlined(
//        MyButtonExample()
//        MyIcon()
//        MyProgressAdvance()
//        MyCheckBox()
//        MyCheckBoxWithText()
//        MyCheckBoxWithTextCompleted(checkInfo)
//        MyRadioButton()

    }
}

//@Preview

@Composable
fun MyDropDownMenu() {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val desserts = listOf("Helado", "Chocolate", "Café", "Fruta", "Natillas", "Chilaquiles")

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedText = dessert
                }) {
                    Text(text = dessert)
                }
            }
        }
    }
}
@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), elevation = 12.dp, shape = MaterialTheme.shapes.small,
        backgroundColor = Color.Green, border = BorderStroke(5.dp, Color.Green)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")

        }
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {
    Column(Modifier.fillMaxSize()) {
        Row() {
            RadioButton(selected = name == "Aris", onClick = { onItemSelected("Aris") })
            Text(text = "Aris")
        }
        Row() {
            RadioButton(selected = name == "David", onClick = { onItemSelected("David") })
            Text(text = "David")
        }
        Row() {
            RadioButton(selected = name == "Pedro", onClick = { onItemSelected("Pedro") })
            Text(text = "Pedro")
        }
        Row() {
            RadioButton(selected = name == "Pepe", onClick = { onItemSelected("Pepe") })
            Text(text = "Pepe")
        }
    }
}

@Composable
fun MyRadioButton() {
    Row(Modifier.fillMaxSize()) {

        RadioButton(
            selected = false,
            onClick = { },
            enabled = false,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledColor = Color.Green
            )
        )
    }
    Text(text = "Ejemplo 1")
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> {
                ToggleableState.Off
            }
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }
}

//@Preview
@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }
    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Ejemplo1")
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(false) }


    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )
}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(false) }

    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Magenta,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan,
            checkedTrackAlpha = 0.1f,
            uncheckedTrackAlpha = 0.1f,
            disabledCheckedTrackColor = Color.Yellow,
            disabledCheckedThumbColor = Color.Yellow,
            disabledUncheckedThumbColor = Color.Yellow,
            disabledUncheckedTrackColor = Color.Yellow
        )
    )

}

@Composable
fun MyProgressAdvance() {
    var progressStatus by rememberSaveable { mutableStateOf(0f) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(progress = progressStatus)

        Row(Modifier.fillMaxWidth(), Arrangement.Center) {
            Button(onClick = { progressStatus += 0.1f }) {
                Text(text = "Incrementar")
            }
            Button(onClick = { progressStatus -= 0.1f }) {
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun MyProgress() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.LightGray,
                backgroundColor = Color.Green
            )
        }

        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Cargar perfil")
        }
    }
}

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "Icono",
        tint = Color.Red
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.5f
    )
}

@Composable
fun MyButtonExample() {
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledBackgroundColor = Color.Blue,
                disabledContentColor = Color.Red
            )
        ) {
            Text(text = "Hola")
        }

        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Hola")
        }
    }
}

@Composable
fun MyTextFielOutlined() {
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Introduce un texto") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyTextFieldAdvanced() {
    var myText by remember { mutableStateOf("") }
    TextField(value = myText, onValueChange = {
        myText = it
    }, label = { Text(text = "Introduce un texto") })
}

@Composable
fun MyTextfield(name: String, onValueChanged: (String) -> Unit) {

    TextField(value = name, onValueChange = { onValueChanged(it) })
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraLight)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(
                textDecoration =
                TextDecoration.combine(
                    listOf(
                        TextDecoration.Underline,
                        TextDecoration.LineThrough
                    )
                )
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)
    }

}


@Composable
fun MyStateExample() {

    var counter by rememberSaveable { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado ${counter} veces")

    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text(text = "Box # uno")
        }
        MySpacer(size = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Text(text = "Box # dos")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text(text = "Box # tres")
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Yellow), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Box # cuatro")
        }
    }

}

@Composable
fun MyRow() {
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Cyan)
                .weight(1f)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Cyan)
                .weight(1f)
        )
    }

}

@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}

@Composable
fun MyBox(name: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(Color.Cyan)
        )
    }
}

