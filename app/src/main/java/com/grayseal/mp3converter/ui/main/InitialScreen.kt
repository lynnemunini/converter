package com.grayseal.mp3converter.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grayseal.mp3converter.R
import com.grayseal.mp3converter.ui.theme.jakartaFamily

@Composable
fun InitialScreen() {
    var url by remember {
        mutableStateOf("")
    }
    Content(enabled = true, url = url, onUrlChange = { url = it })
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Content(enabled: Boolean, url: String, onUrlChange: (String) -> Unit) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 35.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.youtube),
                contentDescription = "youtube icon",
                modifier = Modifier.size(50.dp)
            )
            Text(
                text = "MP3 Downloader",
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
                fontFamily = jakartaFamily
            )
        }
        Text(
            text = "Youtube Link",
            fontSize = 14.sp,
            fontWeight = FontWeight.Black,
            fontFamily = jakartaFamily
        )
        OutlinedTextField(
            value = url,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.outline_insert_link_24),
                    contentDescription = "Link Icon",
                    modifier = Modifier.rotate(45F)
                )
            },
            shape = RoundedCornerShape(),
            singleLine = true,
            enabled = enabled,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions {
                keyboardController?.hide()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            onValueChange = onUrlChange,
            placeholder = { Text(text = "Enter youtube URL", fontFamily = jakartaFamily) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.LightGray,
                focusedLeadingIconColor = Color.Black,
                unfocusedLeadingIconColor = Color.Black,
                placeholderColor = Color.LightGray,
                cursorColor = Color.LightGray
            )
        )
    }
}