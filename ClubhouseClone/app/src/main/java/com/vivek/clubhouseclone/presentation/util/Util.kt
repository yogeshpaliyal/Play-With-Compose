package com.vivek.clubhouseclone.presentation.util

fun <T> List<T>.toGridList(cols: Int) =
    chunked(size = cols).map { rowList ->
        rowList.plus(List(size = cols - rowList.size) { null })
    }

fun getTextWithEllipses(text: String, ellipseAfter: Int) =
    if (text.length > ellipseAfter) text.substring(0, ellipseAfter) + "..." else text