package com.example.timetonictest.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.timetonictest.R
import com.example.timetonictest.login.presentation.LoginViewModel
import com.example.timetonictest.login.presentation.components.DefaultTextField
import com.example.timetonictest.navigation.Directions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginContent(navController: NavHostController) {
    val loginViewModel: LoginViewModel = hiltViewModel()
    val viewState by loginViewModel.viewState.collectAsState()
    val login = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }


    LaunchedEffect(viewState) {
        when (viewState) {
            is LoginViewModel.ViewState.Loaded -> {
                val user = (viewState as LoginViewModel.ViewState.Loaded).user
                navController.navigate(Directions.Home.navigate(user))
            }
            is LoginViewModel.ViewState.Error -> {}
            is LoginViewModel.ViewState.Loading -> {

            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_login_background),
            contentDescription = "background",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(0.5f, 0.5f, 0.5f, 0.8f)
            })
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 150.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .height(120.dp)
                    .width(168.dp),
                tint = Color.White,
            )
        }

        Column(
            modifier = Modifier.padding(top = 300.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                value = login.value,
                onValueChange = { login.value = it },
                hint = stringResource(id = R.string.email),
                isForgotPassword = false
            )
            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                value = password.value,
                onValueChange = { password.value = it },
                hint = stringResource(id = R.string.password),
                isForgotPassword = false
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(56.dp),
                onClick = {
                    loginViewModel.loginUser(login.value, password.value)
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }

    }
}

@Composable
fun IndeterminateCircularIndicator() {
    var loading by remember { mutableStateOf(false) }

    Button(onClick = { loading = true }, enabled = !loading) {
        Text("Start loading")
    }

    if (!loading) return

    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = MaterialTheme.colorScheme.secondary,
    )
}

@Preview
@Composable
fun LoginContentPreview() {
    LoginContent(navController = NavHostController(LocalContext.current))
}
