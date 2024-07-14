package com.example.jetpackcompose.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.jetpackcompose.Model.Data.Product
import com.example.jetpackcompose.Model.Data.User
import com.example.jetpackcompose.ViewModels.ProductViewModel
import com.example.jetpackcompose.ViewModels.UserViewModel


@Composable
fun UserScreen(userVM: UserViewModel){
    val users by userVM.users.observeAsState(emptyList())
    LazyColumn {
        items(users) {
            UserItem(user = it)
        }
    }
}
@Composable
fun UserItem(user: User){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = user.userName)
            Text(text = user.pass)
        }

    }
}