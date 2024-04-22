package com.example.composecomponents

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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

