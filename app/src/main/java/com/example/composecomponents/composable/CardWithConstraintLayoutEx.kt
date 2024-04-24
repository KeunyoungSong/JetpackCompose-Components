package com.example.composecomponents.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage

private val cardData = CardData(
    imageUrl = "https://picsum.photos/id/237/200/200",
    imageDescription = "랜덤이미지",
    author = "Song",
    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
)
@Composable
fun CardWithConstraintLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        CardEx(cardData)
        CardEx(cardData)
        CardEx(cardData)
    }
}
@Composable
fun CardEx(cardData: CardData) {
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = CardDefaults.cardElevation(8.dp), modifier = Modifier
            .padding(4.dp)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (profileImage, author, description) = createRefs()

            AsyncImage(
                model = cardData.imageUrl,
                contentDescription = cardData.imageDescription,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .constrainAs(profileImage) {
                        centerVerticallyTo(parent)
                        start.linkTo(parent.start, margin = 8.dp)
                    },
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(Color(0x33000000))
            )

            Text(text = cardData.author, modifier = Modifier.constrainAs(author) {
                linkTo(start = profileImage.end, end = parent.end, startMargin = 8.dp, endMargin = 8.dp)
                // 텍스트 영역 제한
                width = Dimension.fillToConstraints
            })

            Text(text = cardData.description, modifier = Modifier.constrainAs(description) {
                linkTo(profileImage.end, parent.end, startMargin = 8.dp, endMargin = 8.dp)
                width = Dimension.fillToConstraints
            })

            // 카드 내 여백 주기, ConstraintLayout 에서도 가능
            val chain = createVerticalChain(author, description, chainStyle = ChainStyle.Packed)
            constrain(chain){
                top.linkTo(parent.top, margin = 8.dp)
                bottom.linkTo(parent.bottom, margin = 8.dp)
            }
        }
    }
}