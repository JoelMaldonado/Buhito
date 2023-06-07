package com.jjmf.elementaryschool.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jjmf.elementaryschool.ui.theme.ColorT1


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemMaestro(
    @DrawableRes img: Int,
    init:String? = null,
    titulo: String,
    descrip: String,
    click:()->Unit,
    onlongClick:()->Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .combinedClickable(
                    onClick = click,
                    onLongClick = onlongClick
                )
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            if (init!=null){

                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .background(ColorT1),
                    contentAlignment = Alignment.Center
                ) {
                    if (init.isEmpty()) {
                        Icon(
                            imageVector = Icons.Default.QuestionMark,
                            contentDescription = null,
                            tint = Color.White
                        )
                    } else {
                        Text(
                            text = init,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 24.sp
                        )
                    }
                }
            }else{
                Image(
                    painter = painterResource(id = img),
                    contentDescription = null,
                    modifier = Modifier.size(70.dp)
                )
            }
            Column {
                Text(text = titulo, fontWeight = FontWeight.Medium)
                Text(text = descrip, fontSize = 14.sp, color = Color.Gray.copy(0.5f))
            }
        }
        Divider()
    }
}