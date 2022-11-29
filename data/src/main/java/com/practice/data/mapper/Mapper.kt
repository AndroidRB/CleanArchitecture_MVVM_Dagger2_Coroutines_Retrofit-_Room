package com.practice.data.mapper

interface Mapper<I, O> {
    fun map(i: I): O
}