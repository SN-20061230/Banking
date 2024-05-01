package uz.sardor.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.sardor.profile.ui.theme.Zinc
import uz.sardor.profile.ui.theme.poppinsFamily

@Composable
fun SurfaceWithBackgroundImage(
    backgroundImage: Painter,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = null,
            alignment = Alignment.TopCenter
        )
        content()
    }
}

@Composable
fun MyContent() {

    Row(
        modifier = Modifier
            .padding(20.dp)
            .padding(top = 30.dp)
            .fillMaxWidth(),
    ){
        Column(
            modifier = Modifier.weight(0.7f),
            horizontalAlignment = Alignment.Start
        ){
            Text(
                text = "Good afternoon,",
                fontSize = 18.sp,
                color = Color.White,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "Enjelin Morgeana",
                fontSize = 24.sp,
                color = Color.White,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Medium
            )
        }

        Column(  modifier = Modifier.weight(0.3f),  horizontalAlignment = Alignment.End){
            Image(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        BorderStroke(1.dp, Color.Transparent),
                        shape = RoundedCornerShape(25.dp),
                    )
                    .clickable {}
            )

        }

    }


    Card(
        modifier = Modifier
            .padding(top = 150.dp, start = 25.dp, end = 25.dp)
            .fillMaxWidth()
            .shadow(10.dp, RoundedCornerShape(8.dp))
            .padding(bottom = 3.dp) // Add extra padding at the bottom for the second shadow
            .shadow(6.dp, RoundedCornerShape(8.dp))

        ,


    ) {
        Column(
            modifier = Modifier
                .background(Zinc)
                .fillMaxWidth()
                .padding(16.dp),
//            horizontalAlignment = Alignment.Start
        ){
           Row(modifier = Modifier
               .fillMaxWidth()
               .padding(start = 15.dp, end = 15.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
               Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically){
                   Text(
                       text = "Total Balance",
                       fontSize = 18.sp,
                       color = Color.White,
                       fontFamily = poppinsFamily,
                       fontWeight = FontWeight.Medium,
                   )
                   Image(
                       painter = painterResource(id = R.drawable.ic_back),
                       contentDescription = null,
                       alignment = Alignment.TopCenter
                   )
               }
               Row(modifier = Modifier){
                   Image(
                       painter = painterResource(id = R.drawable.dots_menu),
                       contentDescription = null
                   )
               }

           }

            Text(
                modifier = Modifier.padding(start = 15.dp),
                text = "$ 2,548.00",
                fontSize = 26.sp,
                color = Color.White,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.Bold
            )


            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp), horizontalArrangement = Arrangement.SpaceBetween){
                Column() {
                Row(verticalAlignment = Alignment.CenterVertically){
                    Image(
                        painter = painterResource(id = R.drawable.ic_income),
                        contentDescription = null,
                        modifier = Modifier.padding(start =15.dp),

                    )

                    Text(
                        modifier = Modifier.padding(start =5.dp),
                        text = "Income",
                        fontSize = 18.sp,
                        color = Color.White,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Medium,
                    )
                }
                    Text(
                        modifier = Modifier.padding(start = 20.dp),
                        text = "$1,840.00",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Medium
                    )

                }
                Column() {
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Image(
                            painter = painterResource(id = R.drawable.ic_expense),
                            contentDescription = null,
                            modifier = Modifier.padding(end =5.dp),

                            )

                        Text(
                            modifier = Modifier.padding(end =25.dp),
                            text = "Expenses",
                            fontSize = 18.sp,
                            color = Color.White,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = "$284.00",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Medium
                    )
                }

            }
        }

    }



Row(modifier = Modifier
    .fillMaxWidth()
    .padding(top = 370.dp, )){
    Text(text = "Transactions History", color = Color.Black,fontWeight = FontWeight.Medium, fontFamily = poppinsFamily, fontSize = 16.sp)
//    Text(text = "See all", color = Color.Black, fontWeight = FontWeight.Normal, fontFamily = poppinsFamily)

    Column(){
        LazyColumn(modifier = Modifier.padding(0.dp)) {
            items(10) { index ->
                TextItem(index)
            }
        }
    }


}


}

@Preview(showBackground = true)
@Composable
fun SurfaceWithBackgroundImagePreview() {
    SurfaceWithBackgroundImage(
        backgroundImage = painterResource(id = R.drawable.ic_topbar),
    ) {
        MyContent()


    }


}

@Composable
fun TextItem(index: Int) {
    Text(text = "Salom $index")
}