package com.example.its.domain.issue

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 課題サービス
 */
@Service
class IssueService(private val issueRepository: IssueRepository) {

    /**
     * 全件検索
     * @return 課題一覧
     */
    fun findAll(): List<IssueEntity> {
        return issueRepository.findAll()
    }

    /**
     * 登録（トランザクション制御あり）
     * @param summary 概要
     * @param description 説明
     */
    @Transactional
    fun create(summary: String, description: String) {
        issueRepository.insert(summary, description)
    }

    /**
     * 取得
     * @param issueId 課題ID
     * @return 課題エンティティ
     */
    fun findById(issueId: Long): IssueEntity? {
        return issueRepository.findById(issueId)
    }

    /**
     * 削除
     * @param issueId 課題ID
     */
    fun delete(issueId: Long) {
        issueRepository.deleteById(issueId)
    }
}
