package com.practice.myapp.common

interface Mapper<I, O> {
    fun map(i: I): O
}