package com.example.capstoneproject.ui.presentation.MainScreen.Screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.capstoneproject.ProductNavigation
import com.example.capstoneproject.R
import com.example.capstoneproject.ui.presentation.MainScreen.Screen.ProductData.Product
import com.example.capstoneproject.ui.presentation.MainScreen.Screen.ProductData.products


@Composable
fun ProductHomeScreen (navController: NavController){
    Box(modifier = Modifier.fillMaxSize())
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(bottom = 50.dp)
        ){

            TopAppBar()
            TitleSection()
            Spacer(modifier = Modifier.height(16.dp))
            SearchSection()
            Spacer(modifier = Modifier.height(16.dp))
            CategoryTab()
            ProductSection(navController)
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
        ScrollableTabRow(selectedTabIndex = state, contentColor = Color.Black,  edgePadding = 8.dp, backgroundColor = Color.White) {
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

@Composable
fun ProductSection (navController: NavController){
    LazyColumn {
        items(products) { product ->
            ProductItem(
                product,
                onItemClick = {
                    navController.navigate(ProductNavigation.ProductScreen.route + "/${product.id}")
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ProductItem(
    product: Product,
    onItemClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray, shape = RoundedCornerShape(24.dp))
            //.border(BorderStroke(2.dp, Color.Black))
            .height(200.dp)
            .clickable(onClick = onItemClick),
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(product.image),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(0.4f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(product.productName, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = product.productDescription,
                    color = Color(0xFFB1B1B1)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = product.price, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Add to Cart",
                        fontSize = 14.sp,
                        modifier = Modifier
                            .background(Color.Green, shape = CircleShape)
                            .padding(top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp),
                        color = Color.Black
                    )
                }
            }

        }
    }
}
