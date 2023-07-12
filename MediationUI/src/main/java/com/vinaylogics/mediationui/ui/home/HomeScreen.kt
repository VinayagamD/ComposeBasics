package com.vinaylogics.mediationui.ui.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vinaylogics.mediationui.R
import com.vinaylogics.mediationui.ui.models.BottomMenuContent
import com.vinaylogics.mediationui.ui.models.Feature
import com.vinaylogics.mediationui.ui.theme.AquaBlue
import com.vinaylogics.mediationui.ui.theme.Beige1
import com.vinaylogics.mediationui.ui.theme.Beige2
import com.vinaylogics.mediationui.ui.theme.Beige3
import com.vinaylogics.mediationui.ui.theme.BlueViolet1
import com.vinaylogics.mediationui.ui.theme.BlueViolet2
import com.vinaylogics.mediationui.ui.theme.BlueViolet3
import com.vinaylogics.mediationui.ui.theme.ButtonBlue
import com.vinaylogics.mediationui.ui.theme.DarkerButtonBlue
import com.vinaylogics.mediationui.ui.theme.DeepBlue
import com.vinaylogics.mediationui.ui.theme.LightGreen1
import com.vinaylogics.mediationui.ui.theme.LightGreen2
import com.vinaylogics.mediationui.ui.theme.LightGreen3
import com.vinaylogics.mediationui.ui.theme.LightRed
import com.vinaylogics.mediationui.ui.theme.MeditationUIYouTubeTheme
import com.vinaylogics.mediationui.ui.theme.OrangeYellow1
import com.vinaylogics.mediationui.ui.theme.OrangeYellow2
import com.vinaylogics.mediationui.ui.theme.OrangeYellow3
import com.vinaylogics.mediationui.ui.theme.TextWhite
import com.vinaylogics.mediationui.ui.utils.standardQuadFromTo

@Composable
fun HomeScreen() {
    MeditationUIYouTubeTheme {


        Box(
            modifier = Modifier
                .background(DeepBlue)
                .fillMaxSize()
        ) {

            Column {
                GreetingSection("Vinay")
                ChipSection(
                    chips = listOf(
                        "Sweet sleep",
                        "Insomnia",
                        "Depression"
                    )
                )
                CurrentMediation()
                FeatureSection(
                    listOf(
                        Feature(
                            title = "Sleep mediation",
                            R.drawable.ic_headphone,
                            BlueViolet1,
                            BlueViolet2,
                            BlueViolet3
                        ),
                        Feature(
                            title = "Tips for sleeping",
                            R.drawable.ic_videocam,
                            LightGreen1,
                            LightGreen2,
                            LightGreen3
                        ),
                        Feature(
                            title = "Night island",
                            R.drawable.ic_headphone,
                            OrangeYellow1,
                            OrangeYellow2,
                            OrangeYellow3
                        ),
                        Feature(
                            title = "Calming sounds",
                            R.drawable.ic_headphone,
                            Beige1,
                            Beige2,
                            Beige3
                        ),
                    )
                )


            }

            BottomMenu(items = listOf(
                BottomMenuContent("Home", R.drawable.ic_home),
                BottomMenuContent("Meditate", R.drawable.ic_bubble),
                BottomMenuContent("Sleep", R.drawable.ic_moon),
                BottomMenuContent("Music", R.drawable.ic_music),
                BottomMenuContent("Profile", R.drawable.ic_profile),
            ), modifier = Modifier.align(Alignment.BottomCenter))


        }

    }
}

@Composable
fun GreetingSection(
    name: String  = "Vinay"
){

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good morning, $name",
                style = MaterialTheme.typography.h2
            )

            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.body1
            )
        }

            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )


    }
}


@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chips.size) {
            Box(modifier = Modifier
                .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                .clickable {
                    selectedChipIndex = it
                }
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (selectedChipIndex == it) ButtonBlue
                    else DarkerButtonBlue
                )
                .padding(15.dp)
            ){
                Text(text = chips[it], color = TextWhite)
            }
        }
    }

}

@Composable
fun CurrentMediation(
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 15.dp)
            .fillMaxWidth()
    ) {

        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.h2
            )

            Text(
                text = "Mediation . 3-10 min",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
            
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )

        }


    }
}

@Composable
fun FeatureSection(
    features: List<Feature>
){
    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = "Features",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )

        LazyVerticalGrid(
           columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 7.5.dp,
                end = 7.5.dp,
                bottom = 100.dp
            )
        ) {
            items(features.size) {
                FeatureItem(features[it])
            }
        }

    }

}

@Composable
fun FeatureItem(
    feature: Feature
) {

    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium Colored path
        val mediumColouredPoint1 = Offset(0f, height * 0.3f)
        val mediumColouredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColouredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColouredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColouredPoint5 = Offset(width * 1.4f, - height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColouredPoint1.x, mediumColouredPoint1.y)
            standardQuadFromTo(mediumColouredPoint1, mediumColouredPoint2)
            standardQuadFromTo(mediumColouredPoint2, mediumColouredPoint3)
            standardQuadFromTo(mediumColouredPoint3, mediumColouredPoint4)
            standardQuadFromTo(mediumColouredPoint4, mediumColouredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat()+100f)
            lineTo(-100f, height.toFloat()+100f)
            close()
        }

        // Light Colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height * 0.7f)
        val lightPoint5 = Offset(width * 1.4f, - height.toFloat()/3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat()+100f)
            lineTo(-100f, height.toFloat()+100f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ){
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ){
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )

            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )

            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {

                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }

    }

}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighLightColor:Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {

    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighLightColor = activeHighLightColor,
                inactiveTextColor = inactiveTextColor,
                activeTextColor = activeTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }

}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighLightColor:Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighLightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if(isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )


        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DisplayHome(){
    HomeScreen()
}