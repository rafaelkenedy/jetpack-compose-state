package com.rafael.basestatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    val count: MutableState<Int> = rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count = count, onIncrement = { count.value++ }, modifier = modifier)
}

@Composable
private fun StatelessCounter(
    count: MutableState<Int>,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {

        if (count.value > 0) {
            Text("You've had ${count.value} glasses.")
        }

        Button(
            onClick = onIncrement,
            Modifier.padding(top = 8.dp),
            enabled = count.value < 10
        ) {
            Text(text = "Add one")
        }
    }
}
