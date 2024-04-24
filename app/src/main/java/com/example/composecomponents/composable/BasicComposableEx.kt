package com.example.composecomponents.composable

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.composecomponents.R

@Composable
fun TextPractice(name: String) {
    Text(text = "Hello $name!")
    Text(text = "Hello $name!", color = Color.Red)
    Text(text = "Hello $name!", color = Color(0xff00ff44))
    Text(text = "Hello $name!", fontSize = 30.sp)
    Text(text = "Hello $name!", fontSize = 30.sp, fontWeight = FontWeight.Bold)
    Text(text = "Hello $name!", fontSize = 30.sp, fontFamily = FontFamily.Cursive)
    Text(text = "Hello $name!", fontSize = 30.sp, fontStyle = FontStyle.Italic)
    Text(text = "Hello $name!\nHello $name!\nHello $name!", maxLines = 2)
    Text(text = "Hello $name!", textDecoration = TextDecoration.LineThrough)
    Text(text = "Hello $name!", modifier = Modifier.width(200.dp), textAlign = TextAlign.Center)
    Text(text = "Hello $name!", modifier = Modifier.size(200.dp), textAlign = TextAlign.Center)
}
@Composable
fun ButtonPractice(onButtonClick: () -> Unit = {}) {
    // 1. 기본 버튼 생성
    Button(onClick = {}) {
        Text(text = "Add")
    }
    // 2. 버튼 클릭시 Toast 생성
    Button(onClick = onButtonClick) {
        Text(text = "Send")
    }
    // 3. 버튼에 아이콘과 텍스트 추가
    Button(onClick = onButtonClick) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Text(text = "Send")
    }
    // 4. 버튼 아이콘과 텍스트 사이 여백주기
    Button(onClick = onButtonClick) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = "Send")
    }
    // 5. enabled 속성(활/비활성화)
    Button(
        onClick = onButtonClick,
        enabled = false
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = "Send")
    }
    // 6. Button 의 외곽선 추가
    Button(
        onClick = onButtonClick,
        border = BorderStroke(10.dp, Color.Magenta),
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = "Send")
    }
    // 7. Button 에 shape 활용
    Button(
        onClick = onButtonClick,
        shape = RoundedCornerShape(6.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = "Send")
    }
    // 8. Button 에 padding 주기
    Button(
        onClick = onButtonClick,
        shape = RoundedCornerShape(6.dp),
        contentPadding = PaddingValues(20.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = "Send")
    }
}

@Composable
fun ModifierPractice() {
    // 1. 화면 가득 채우기
    Button(onClick = {}, modifier = Modifier.fillMaxSize()) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = "Send")
    }
    // 2. 다중 옵션 지정을 위한 체이닝
    Button(
        onClick = {}, modifier = Modifier
            .height(100.dp)
            .width(200.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = "Send")
    }
    // 3. 가로 세로 옵션을 한 번에 지정하는 방법
    Button(onClick = {}, modifier = Modifier.size(200.dp)) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = "Send")
    }
    // 4. 버튼 색상 변경 방법(버튼은 modifier 로 배경색 변경 안됨)
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Yellow,
            contentColor = Color.Magenta,
        ),
        modifier = Modifier.background(Color.Green)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = "Send")
    }
    // 5. 버튼에 padding 주기
    Button(
        onClick = {},
        modifier = Modifier
            .padding(40.dp)
            .background(Color.White),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = "Send")
    }
    // 6. 버튼의 일부 요소만 클릭 가능하게 변경
    Button(
        onClick = {}, modifier = Modifier
            .size(200.dp)
            .padding(20.dp), enabled = false
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = "Send", modifier = Modifier.clickable {})
    }
    // 7. offset 적용
    Button(onClick = {}, modifier = Modifier.size(200.dp), colors = ButtonDefaults.buttonColors(Color.Cyan)) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
        Text(text = "Send", modifier = Modifier.offset(x = 20.dp, y = (-50).dp))
    }
}
@Composable
fun SurfacePractice() {
    // 1. 기본 Surface
    Surface(
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = "Hello Song",
        )
    }
    // 2. Margin 을 위해선 그 윗 레벨에 padding 을 줘야한다
    Surface(
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = "Hello Song",
            Modifier.padding(8.dp)
        )
    }
    // 3. 그림자 효과
    Surface(
        modifier = Modifier.padding(5.dp),
        shadowElevation = 20.dp
    ) {
        Text(
            text = "Hello Song",
            Modifier.padding(8.dp)
        )
    }
    // 4. Boarder 넣기
    Surface(
        modifier = Modifier.padding(5.dp),
        shadowElevation = 20.dp,
        border = BorderStroke(width = 2.dp, color = Color.Magenta)
    ) {
        Text(
            text = "Hello Song",
            Modifier.padding(8.dp)
        )
    }
    // 5. Surface 의 shape 설정
    Surface(
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, color = Color.Magenta)
    ) {
        Text(
            text = "Hello Song",
            modifier = Modifier.padding(8.dp)
        )
    }
    // 6. Surface 의 컬러 지정
    Surface(
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, color = Color.Green),
        color = MaterialTheme.colorScheme.error
    ) {
        Text(
            text = "Hello Song",
            modifier = Modifier.padding(8.dp)
        )
    }
}
@Composable
fun BoxPractice() {
    // 1. 기본 박스 만들기
    Box(modifier = Modifier.size(100.dp)) {
        Text(text = "Hello World", modifier = Modifier.align(Alignment.Center))
    }
    // 2. 박스 안 다중 컴포넌트 배치
    Box(modifier = Modifier.size(200.dp, 100.dp)) {
        Text(text = "Hello World", modifier = Modifier.align(Alignment.TopStart))
        Text(text = "Hello World", modifier = Modifier.align(Alignment.Center))
        Text(text = "Hello World", modifier = Modifier.align(Alignment.BottomEnd))
    }
    // 3. 박스 내 다중 박스 배치, 부모 modifier 설정을 제거하면 기본 사이즈가 잡히지 않음
    Box(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Cyan)
                .align(Alignment.CenterStart)
        )
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Yellow)
                .align(Alignment.Center)
        )
    }
}
@Composable
fun RowPractice() {
    // 1. 기본 Row 사용
    Row(
        modifier = Modifier
            .height(100.dp)
            .background(Color.Yellow)
    ) {
        Text("첫번째")
        Text("두번째")
        Text("세번째")
    }
    // 2. Row 내부 컴포넌트 정렬하기
    Row(
        modifier = Modifier
            .height(100.dp)
            .background(Color.Yellow)
    ) {
        Text("첫번째", Modifier.align(Alignment.Top))
        Text("두번째", Modifier.align(Alignment.CenterVertically))
        Text("세번째", Modifier.align(Alignment.Bottom))
    }
    // 3. Row 내부 컴포넌트 일괄 지정. 내부 컴포넌트에 정렬 기준을 지정하면 그 설정이 우선됨
    Row(
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
            .background(Color.Yellow),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("첫번째")
        Text("두번째")
        Text("세번째", Modifier.align(Alignment.Top))
    }
    // 4. Row 내부 컴포넌트에 가중치 사용
    Row(
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
            .background(Color.Magenta),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "첫번째",
            Modifier
                .background(Color.Green)
                .weight(1f)
        )
        Text(
            "두번째",
            Modifier
                .background(Color.Red)
                .weight(2f)
        )
        Text("세번째", Modifier.background(Color.White))
    }
    // 4. Row 내부에 Text 가 아닌 아이콘을 써보자
    Row(
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
            .background(Color.Magenta),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "첫번째",
            Modifier
                .align(Alignment.Top)
                .background(Color.Green)
                .weight(1f),
            textAlign = TextAlign.End
        )
        Icon(
            modifier = Modifier
                .align(Alignment.Bottom)
                .background(Color.Yellow),
            imageVector = Icons.Filled.Add,
            contentDescription = "Add"
        )
        Text(
            "세번째",
            Modifier
                .background(Color.White)
                .weight(1.5f), textAlign = TextAlign.Center
        )
    }
}
@Composable
fun ColumnPractice() {
    // 1. Column 레이아웃 내 컴포넌트 배치는 horizontalAlignment
    Column(
        modifier = Modifier
            .size(200.dp, 100.dp)
            .background(Color.Gray),
        horizontalAlignment = Alignment.End
    ) {
        Text("첫번째", Modifier.background(Color.Yellow))
        Text("두번째", Modifier.background(Color.Green))
        Text("세번째", Modifier.background(Color.White))
    }
    // 2. Alignment 는 진행방향과 수직으로 이뤄짐, Arrangement 는 진행방향으로 이뤄짐
    Column(
        modifier = Modifier
            .size(200.dp, 100.dp)
            .background(Color.Gray),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text("첫번째", Modifier.background(Color.Yellow))
        Text("두번째", Modifier.background(Color.Green))
        Text("세번째", Modifier.background(Color.White))
    }
    // 3. 일괄 정렬이 된 Column 에서 내부 컴포넌트 정렬
    Column(
        modifier = Modifier
            .size(200.dp, 100.dp)
            .background(Color.Gray),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "첫번째",
            Modifier
                .background(Color.Yellow)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            "두번째",
            Modifier
                .background(Color.Green)
                .align(Alignment.Start)
        )
        Text("세번째", Modifier.background(Color.White))
    }
}
@Composable
fun BoxWithConstraintsPractice() {
    Column() {
        // 2. BoxWithConstraints 에서 사용할 Modifier 세팅
        Inner(
            Modifier
                .widthIn(min = 240.dp, max = 300.dp)
                .heightIn(min = 200.dp, max = 300.dp)
        )
        Inner(
            Modifier
                .width(200.dp)
                .height(140.dp)
        )
    }
}
@Composable
fun Inner(modifier: Modifier = Modifier) {
    // 1. Inner 로 modifier 를 전달받아 BoxWithConstraints 에서 사용해보기
    BoxWithConstraints(modifier.background(Color.Gray)) {
        // 3. 특정 화면 크기에서만 새로운 내용 보이기
        if (maxHeight > 150.dp) {
            Text(text = "여기 꽤 길군요!", modifier = Modifier.align(Alignment.BottomCenter))
        }
        Text("maxW:$maxWidth, maxH:$maxHeight, minW:$minWidth, minH:$minHeight")
    }
}
@Composable
fun ImagePractice() {
    // 1. 이미지 만들기
    Image(
        painter = painterResource(id = R.drawable.wall),
        contentDescription = "색상표"
    )
    // 2. 이미지 벡터를 사용한 이미지 만들기
    Image(imageVector = Icons.Filled.Settings, contentDescription = "세팅")
}
@Composable
fun CoilPractice() {
    // 1. rememberPainter 를 이용해 Image 사용
    Column {
        val painter = rememberImagePainter(data = "https://picsum.photos/id/237/600/600")
        Image(
            painter = painter,
            contentDescription = "랜덤 이미지"
        )
        // 2. Coil 권장 사항인 AsyncImage 를 사용
        AsyncImage(model = "https://picsum.photos/id/237/200/300", contentDescription = "랜덤이미지")
    }
}

private val cardData = CardData(
    imageUrl = "https://picsum.photos/id/237/200/200",
    imageDescription = "랜덤이미지",
    author = "Song",
    description = "송근영이 찍은 사진입니다. 개 사진이 나올겁니다"
)
@Composable
fun CardPractice(cardData: CardData) {
    // 1. 여러 요소를 포함한 Card 레이아웃 그리기
    Column {
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                AsyncImage(
                    model = cardData.imageUrl,
                    contentDescription = cardData.imageDescription,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape), contentScale = ContentScale.Crop,
                    placeholder = ColorPainter(Color(0x33000000))
                )
                Spacer(modifier = Modifier.size(8.dp))
                Column {
                    Text(cardData.author)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(cardData.description)
                }
            }
        }
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                AsyncImage(
                    model = cardData.imageUrl,
                    contentDescription = cardData.imageDescription,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape), contentScale = ContentScale.Crop,
                    placeholder = ColorPainter(Color(0x33000000))
                )
                Spacer(modifier = Modifier.size(8.dp))
                Column {
                    Text(cardData.author)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(cardData.description)
                }
            }
        }
    }
}
@Composable
fun CheckBoxPractice() {
    Column {
        // 1. 기본 checkbox 는 터치해도 상태를 바꾸지 않는다
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = false, onCheckedChange = {})
            Text(text = "당신은 프로그래머입니까?")
        }
        // 2. boolean 값을 사용해 변경하면? 작동하지 않음
        Row(verticalAlignment = Alignment.CenterVertically) {
            var checked = false
            Checkbox(checked = checked, onCheckedChange = {
                checked = checked.not()
            })
            Text(text = "당신은 프로그래머입니까?")
        }
        // 3. Boolean  대시 remember {mutableStateOf(false)} 를 사용해 상태를 처리하자(value 를 사용해야 함)
        // var checked = false 정상 작동 안됨
        Row(verticalAlignment = Alignment.CenterVertically) {
            val checked = remember { mutableStateOf(false) }
            Checkbox(checked = checked.value, onCheckedChange = {
                checked.value = checked.value.not()
            })
            Text(text = "당신은 프로그래머입니까?")
        }
        // 4. 위임된 속성, delegated properties 를 사용해보자
        Row(verticalAlignment = Alignment.CenterVertically) {
            var checked by remember { mutableStateOf(false) }
            Checkbox(checked = checked, onCheckedChange = {
                checked = checked.not()
            })
            Text(text = "당신은 프로그래머입니까?")
        }
        // 5. Destruction 을 사용해보자
        Row(verticalAlignment = Alignment.CenterVertically) {
            val (checked, setChecked) = remember { mutableStateOf(false) }
            Checkbox(checked = checked, onCheckedChange = {
                setChecked(it)
            })
            Text(text = "당신은 프로그래머입니까?")
        }
        // 5.1 Deconstruction 활용
        Row(verticalAlignment = Alignment.CenterVertically) {
            val (getter, setter) = remember { mutableStateOf(false) }
            Checkbox(checked = getter, onCheckedChange = setter)
            Text(text = "당신은 프로그래머입니까?")
        }
        // 6. 체크박스 제어 영역 활장
        Row(verticalAlignment = Alignment.CenterVertically) {
            val (getter, setter) = remember { mutableStateOf(false) }
            Checkbox(checked = getter, onCheckedChange = setter)
            Text(text = "당신은 프로그래머입니까?", modifier = Modifier.clickable {
                setter(!getter)
            })
        }
    }
}
@Composable
fun TextFieldPractice() {
    var name by remember { mutableStateOf("Tom") }
    Column(modifier = Modifier.padding(16.dp)) {
        // 1. TextField 사용
        TextField(value = "Tom", onValueChange = {})
        // 2. TextField 에 외부 상태 적용
        TextField(value = name, onValueChange = { name = it })
        // 3. TextField 에 라벨 부착
        TextField(value = name, onValueChange = { name = it }, label = { Text(text = "이름") })
        // 4.OutlinedTextField 를 사용해보자
        OutlinedTextField(value = name, onValueChange = { name = it })

        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Hello $name")
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarPractice() {
    Column {
        // 1. 기본 TopAppBar 사용
        TopAppBar(title = { Text(text = "TopAppBar") })
        // 2. navigationIcon 파라미터 사용
        TopAppBar(title = { Text(text = "TopAppBar") },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "업 네비게이션")
                }
            })
        // 3. actions 파라미터 사용
        TopAppBar(title = { Text(text = "TopAppBar") },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "업 네비게이션")
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "검색")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "설정")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "계정")
                }
            })


        Text(text = "Hello Android")
    }
}
@Composable
fun SlotAPI() {
    val checked1 = remember { mutableStateOf(false) }
    val checked2 = remember { mutableStateOf(false) }
    val checked3 = remember { mutableStateOf(false) }
    var checked4 by remember { mutableStateOf(false) }

    Column {
        // 1. Slot API 구현을 위해 컴포저블 분리
        CheckboxWithSlot(checked = checked1) {
            Text(text = "텍스트1")
        }
        CheckboxWithSlot(checked = checked2) {
            Text(text = "텍스트2")
        }
        // 2. Slot API 다운 함수 작성
        CheckboxWithoutState(
            checked = checked3.value,
            onCheckedChanged = { checked3.value = checked3.value.not() }) {
            Text("텍스트3")
        }
        // 3. 위임 선언 활용
        CheckboxWithoutState(checked = checked4, onCheckedChanged = { checked4 = checked4.not() }) {
            Text("텍스트3")
        }
    }
}
@Composable
fun CheckboxWithSlot(checked: MutableState<Boolean>, content: @Composable RowScope.() -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { checked.value = !checked.value }
    ) {
        Checkbox(checked = checked.value, onCheckedChange = { checked.value = it })
        // 외부에서 content 를 통해 같이 사용할 Text 를 가져오도록 구현
        // Text(text = text, modifier = Modifier.clickable { checked.value = !checked.value })
        content()
        // Text 요소를 외부로 빼면서 Text 의 Clickable 상태를 잃음. 때문에 Row 자체에 기능을 추가.
        // Row 에 설정을 했어도 checkbox 영역이 선택되면 이벤트를 checkbox 가 소모한다.
        // 따라서 양쪽 모두 리스너를 부착
        // content 를 통해 전달되는 Text 는 내부적으로 row 스코프 내에 배치된다
        // content 를 전달하는 함수 내에서 row scope 의 기능을 활용할 수 있도록 content 를 확장 함수로 선언한다
    }
}
@Composable
fun CheckboxWithoutState(
    checked: Boolean,
    onCheckedChanged: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    // 상태 변경 로직을 외부에서 가져오기
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChanged()
        }
    ) {
        Checkbox(checked = checked, onCheckedChange = { onCheckedChanged() })
        content()
    }
}
@Composable
fun CheckBoxWithContent(
    checked: Boolean,
    toggleState: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable { toggleState() }) {
        Checkbox(checked = checked, onCheckedChange = { toggleState() })
        content()
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldPractice() {
    var checked by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "TopAppBar") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "뒤로가기")
                    }
                })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
            }
        }
    ) {
        Surface(modifier = Modifier.padding(8.dp)) {
            CheckBoxWithContent(checked = checked, toggleState = { checked = checked.not() }) {
                Text(text = "컴포즈 연습중")
            }
        }
    }
}
@Composable
fun LazyColumnPractice() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        LazyColumn {
            items(itemList){ item ->
                Item(item)
            }
            // 직접 추가
//            item {
//                Item(itemList[0])
//                Item(itemList[1])
//                Item(itemList[2])
//                Item(itemList[3])
//            }
        }
    }
}

@Composable
fun Item(itemData: ItemData) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp), modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = itemData.imageId),
                contentDescription = itemData.title,
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = itemData.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = itemData.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

data class ItemData(
    @DrawableRes val imageId: Int,
    val title: String,
    val description: String,
)

val itemList = listOf(
    ItemData(
        imageId = R.drawable.wall,
        title = "해변 놀이 공원",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed vulputate odio ut enim blandit volutpat. Sit amet purus gravida quis blandit. Ultricies lacus sed turpis tincidunt id aliquet risus feugiat. Sed arcu non odio euismod. Dictumst quisque sagittis purus sit amet. Amet commodo nulla facilisi nullam vehicula ipsum a arcu. Sed viverra tellus in hac habitasse platea dictumst vestibulum rhoncus. Facilisis gravida neque convallis a cras semper auctor neque."
    ),
    ItemData(
        imageId = R.drawable.wall,
        title = "해변 놀이 공원2",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed vulputate odio ut enim blandit volutpat. Sit amet purus gravida quis blandit. Ultricies lacus sed turpis tincidunt id aliquet risus feugiat. Sed arcu non odio euismod. Dictumst quisque sagittis purus sit amet. Amet commodo nulla facilisi nullam vehicula ipsum a arcu. Sed viverra tellus in hac habitasse platea dictumst vestibulum rhoncus. Facilisis gravida neque convallis a cras semper auctor neque."
    ),
    ItemData(
        imageId = R.drawable.wall,
        title = "해변 놀이 공원3",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed vulputate odio ut enim blandit volutpat. Sit amet purus gravida quis blandit. Ultricies lacus sed turpis tincidunt id aliquet risus feugiat. Sed arcu non odio euismod. Dictumst quisque sagittis purus sit amet. Amet commodo nulla facilisi nullam vehicula ipsum a arcu. Sed viverra tellus in hac habitasse platea dictumst vestibulum rhoncus. Facilisis gravida neque convallis a cras semper auctor neque."
    ),
    ItemData(
        imageId = R.drawable.wall,
        title = "해변 놀이 공원4",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed vulputate odio ut enim blandit volutpat. Sit amet purus gravida quis blandit. Ultricies lacus sed turpis tincidunt id aliquet risus feugiat. Sed arcu non odio euismod. Dictumst quisque sagittis purus sit amet. Amet commodo nulla facilisi nullam vehicula ipsum a arcu. Sed viverra tellus in hac habitasse platea dictumst vestibulum rhoncus. Facilisis gravida neque convallis a cras semper auctor neque."
    ),
    ItemData(
        imageId = R.drawable.wall,
        title = "해변 놀이 공원5",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sed vulputate odio ut enim blandit volutpat. Sit amet purus gravida quis blandit. Ultricies lacus sed turpis tincidunt id aliquet risus feugiat. Sed arcu non odio euismod. Dictumst quisque sagittis purus sit amet. Amet commodo nulla facilisi nullam vehicula ipsum a arcu. Sed viverra tellus in hac habitasse platea dictumst vestibulum rhoncus. Facilisis gravida neque convallis a cras semper auctor neque."
    ),
)



data class CardData(
    val imageUrl: String,
    val imageDescription: String,
    val author: String,
    val description: String
)