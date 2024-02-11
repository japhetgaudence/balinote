package com.balitech.balinote.domain.models.common

import androidx.annotation.ColorRes
import androidx.compose.ui.graphics.Color


sealed class BackgroundColor(
    val id: Int,
    @ColorRes val darkThemeValue: Color,
    @ColorRes val lightThemeValue: Color
) {
    data object None: BackgroundColor(
        id = 0,
        darkThemeValue = Color(0xFF141318),
        lightThemeValue = Color(0xFFFDF8FF)
    )

    data object Purple: BackgroundColor(
        id = 1,
        darkThemeValue = Color(0xFF6146C6),
        lightThemeValue = Color(0xFFCBBEFF)
    )

    data object Pink: BackgroundColor(
        id = 2,
        darkThemeValue= Color(0xFF91002c),
        lightThemeValue = Color(0xFFffb2b8)
    )

    data object Blue: BackgroundColor(
        id = 3,
        darkThemeValue = Color(0xFF0040a2),
        lightThemeValue = Color(0xFFb2c5ff)
    )

    data object Green: BackgroundColor(
        id = 4,
        darkThemeValue = Color(0xFF006c46),
        lightThemeValue = Color(0xFF8bf0ba)
    )

    data object Cyan: BackgroundColor(
        id = 5,
        darkThemeValue = Color(0xFF006972),
        lightThemeValue = Color(0xFF4ed8e7)
    )

    data object Gold: BackgroundColor(
        id = 6,
        darkThemeValue = Color(0xFF895100),
        lightThemeValue = Color(0xFFF7BC70)
    )

    data object Evergreen: BackgroundColor(
        id = 7,
        darkThemeValue = Color(0xFF506600),
        lightThemeValue = Color(0xFFc3f410)
    )

    data object Yellow: BackgroundColor(
        id = 8,
        darkThemeValue = Color(0xFF6d5e00),
        lightThemeValue = Color(0xFFffe252)
    )

    data object Grey: BackgroundColor(
        id = 9,
        darkThemeValue = Color(0xFF393f4d),
        lightThemeValue = Color(0xFFbec6dc)
    )

    data object Silver: BackgroundColor(
        id = 10,
        darkThemeValue = Color(0xFF44464f),
        lightThemeValue = Color(0xFFe1e2ec)
    )


    companion object {

        fun isNone(color: BackgroundColor): Boolean = color == None

        fun getAll(): List<BackgroundColor> =
            listOf(None, Purple, Pink, Blue, Green, Cyan, Gold, Evergreen, Yellow, Grey, Silver)

        fun toUiValue(id: Int): BackgroundColor {
            return when(id) {
                Purple.id -> Purple
                Pink.id -> Pink
                Blue.id -> Blue
                Green.id -> Green
                Cyan.id -> Cyan
                Gold.id -> Gold
                Evergreen.id -> Evergreen
                Yellow.id -> Yellow
                Grey.id -> Grey
                Silver.id -> Silver
                else -> None
            }
        }

        fun toDbValue(color: BackgroundColor): Int {
            return when(color) {
                Purple -> Purple.id
                Pink -> Pink.id
                Blue -> Blue.id
                Green -> Green.id
                Cyan -> Cyan.id
                Gold -> Gold.id
                Evergreen -> Evergreen.id
                Yellow -> Yellow.id
                Grey -> Grey.id
                Silver -> Silver.id
                else -> None.id
            }
        }
    }
}