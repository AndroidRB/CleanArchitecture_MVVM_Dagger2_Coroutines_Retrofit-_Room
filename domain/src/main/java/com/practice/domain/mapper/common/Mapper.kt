package com.practice.domain.mapper.common

interface Mapper<I, O> {
    fun map(i: I): O
}