package com.practice.data.repository.mapper.common

interface Mapper<I, O> {
    fun map(i: I): O
}