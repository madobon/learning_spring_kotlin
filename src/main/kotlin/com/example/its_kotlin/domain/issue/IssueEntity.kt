package com.example.its.domain.issue

/**
 * 課題エンティティ
 * @param id ID
 * @param summary 概要
 * @param description 説明
 */
data class IssueEntity(
    val id: Long,
    val summary: String,
    val description: String
)