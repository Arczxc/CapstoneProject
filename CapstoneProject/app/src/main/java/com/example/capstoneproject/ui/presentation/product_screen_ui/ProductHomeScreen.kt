package com.example.capstoneproject.ui.presentation.product_screen_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.capstoneproject.R
import com.example.capstoneproject.ui.presentation.product_screen_ui.bottomNavigationScreen.BottomNavigationWithOnlySelectedLabelsSample



@Composable
fun ProductHomeScreen (){
    Box(modifier = Modifier.fillMaxSize())
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(bottom = 100.dp)
        ){

            TopAppBar()
            TitleSection()
            Spacer(modifier = Modifier.height(16.dp))
            SearchSection()
            Spacer(modifier = Modifier.height(16.dp))
            CategoryTab()
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)){
            BottomNavigationWithOnlySelectedLabelsSample()
        }
    }
}



@Composable
fun TopAppBar (){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = null
        )
    }
}

@Composable
fun TitleSection() {
    Column(
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Text(
            text = "Jah-Jah’s Pet supplies and Accessories shop",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Love them Enough ,Give them Best.",
            color = Color(0xFFCDCDCD)
        )
    }
}

@Composable
fun SearchSection() {
    var searchText = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = searchText.value,
        onValueChange = {
            searchText.value = it
        },
        placeholder = {
            Text(text = "Search here...", color = Color(0xFFCCCCCC))
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF4F4F4), shape = CircleShape),
        shape = CircleShape,
        singleLine = true,
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search_normal_1),
                contentDescription = null
            )
        }
    )
}

@Composable
fun CategoryTab(){
    var state by remember { mutableStateOf(0) }
    val titles = listOf(
        "All",
        "Accessories",
        "Cages",
        "Food",
        "Grooming",
        "Medicine",
        "Nestbox",
        "Toys",
        "Others"


    )
    Column {
        ScrollableTabRow(selectedTabIndex = state, contentColor = Color.Black,  edgePadding = 8.dp) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state == index,
                    onClick = { state = index }
                )
            }
        }
    }
}

