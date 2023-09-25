package com.example.neuz.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Searchbar(
    modifier: Modifier ,
    text : String,
    readOnly : Boolean ,
    onClick : (()->Unit)?=null,
    onValueChange :(String) -> Unit,
    onSearch : () -> Unit
){}

