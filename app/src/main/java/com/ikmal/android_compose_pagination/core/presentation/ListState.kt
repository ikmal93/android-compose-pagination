package com.ikmal.android_compose_pagination.core.presentation

/**
 * source : https://proandroiddev.com/pagination-in-jetpack-compose-with-and-without-paging-3-e45473a352f4
 */
enum class ListState {
    IDLE,
    LOADING,
    PAGINATING,
    ERROR,
    PAGINATION_EXHAUST,
}