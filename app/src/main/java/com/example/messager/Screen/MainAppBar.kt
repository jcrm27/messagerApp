package com.example.messager.Screen


import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.messager.ui.theme.Purple500


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar() {

    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor =Purple500 ),
        title = {
            Text(text = "Messenger Chat" )
        },



       // colors = TopAppBarColors,
        //Modifier.background(Color.Gray),
       // colors = MaterialTheme.colorScheme. .TopBarColor,
        //if(NavItem.Main.route){}
       /* navigationIcon = {
                         ArrowBackIcon( onUpClick = {/*TODO*/})
        },*/
        actions = {
        /*AppBarAction(
             imageVector = Icons.Filled.Share,
             onClick ={/*TODO*/}
        )*/
        AppBarAction(
            imageVector = Icons.Filled.Settings,
            onClick ={/*TODO*/}
         )
        }
    )



}


@Composable
private fun AppBarAction(
    imageVector: ImageVector,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = imageVector,
            contentDescription = null
        )
    }
}
