package com.example.composecomponents.composable.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun ConstraintPractice() {
    // 1. 의존성 추가
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // 2. 레퍼런스 생성, createRef() 와 createRefs() 가 있다
        // createRefs 는 레퍼런스를 최대 16개까지 가져올 수 있다
        val (redBox, magentaBox, greenBox, yellowBox, blackBox) = createRefs()
        // 3. constraintAs modifier 추가
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    // 4. 제약조건 주기
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                    end.linkTo(parent.end, margin = 30.dp)
                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .constrainAs(greenBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    centerVerticallyTo(parent)
                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Black)
                .constrainAs(blackBox) {
                    start.linkTo(magentaBox.end)
                    top.linkTo(magentaBox.bottom)
                }
        )
    }
}
@Composable
fun ConstraintSetPractice() {
    val constraintSet = ConstraintSet {
        // 1. 레퍼런스 생성
        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")
        val blackBox = createRefFor("blackBox")

        constrain(redBox) {
            bottom.linkTo(parent.bottom, margin = 10.dp)
            end.linkTo(parent.end, margin = 30.dp)
        }
        constrain(magentaBox) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(greenBox) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }
        constrain(yellowBox) {
            centerVerticallyTo(parent)
        }
        constrain(blackBox) {
            start.linkTo(magentaBox.end)
            top.linkTo(magentaBox.bottom)
        }
    }
    ConstraintLayout(modifier = Modifier.fillMaxSize(), constraintSet = constraintSet) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("redBox")
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .layoutId("magentaBox")
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .layoutId("greenBox")
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .layoutId("yellowBox")
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Black)
                .layoutId("blackBox")
        )
    }
}
@Composable
fun ConstraintLayoutPractice2() {
    // Chain, Barrier 활용
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (redBox, yellowBox, magentaBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    top.linkTo(parent.top, margin = 18.dp)
                }
        )


        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    top.linkTo(parent.top, margin = 32.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    top.linkTo(parent.top, margin = 50.dp)
                }
        )
        // 1. createVerticalChain, createHorizontalChain 활용
        createVerticalChain(redBox, yellowBox, magentaBox)
        createHorizontalChain(redBox, yellowBox, magentaBox)
        // 2. Chain 에 style 을 적용해보자
        createHorizontalChain(redBox, yellowBox, magentaBox, chainStyle = ChainStyle.SpreadInside)
        // 3. Barrier 활용
        val barrierRef = createBottomBarrier(redBox, yellowBox, magentaBox)
        // 4. Text 를 barrier 기준으로 위치시킨다
        Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pellentesque diam volutpat commodo sed egestas egestas fringilla phasellus. Venenatis tellus in metus vulputate eu scelerisque felis. Nibh sit amet commodo nulla. Varius sit amet mattis vulputate. Sit amet volutpat consequat mauris nunc congue nisi vitae. Tempor nec feugiat nisl pretium fusce id. Dui id ornare arcu odio ut. Convallis aenean et tortor at risus viverra adipiscing. Cursus euismod quis viverra nibh cras pulvinar. Eget sit amet tellus cras adipiscing enim eu turpis egestas. Mattis vulputate enim nulla aliquet porttitor lacus luctus accumsan.",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(barrierRef)
            })
    }
}