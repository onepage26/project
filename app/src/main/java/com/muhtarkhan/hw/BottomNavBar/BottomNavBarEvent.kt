package com.muhtarkhan.hw.BottomNavBar

sealed interface BottomNavBarEvent {
    object OnCatalog : BottomNavBarEvent

    object OnSearchClicked : BottomNavBarEvent

    object OnProfileClicked : BottomNavBarEvent

}