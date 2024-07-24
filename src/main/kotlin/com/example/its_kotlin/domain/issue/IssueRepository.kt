package com.example.its.domain.issue

import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

/**
 * 課題レポジトリ
 */
@Mapper
interface IssueRepository {

    /**
     * 全件検索
     * @return 課題一覧
     */
    @Select("select * from issues")
    fun findAll(): List<IssueEntity>

    /**
     * 登録
     * @param summary 概要
     * @param description 説明
     */
    @Insert("insert into issues (summary, description) values(#{summary}, #{description})")
    fun insert(summary: String, description: String)

    /**
     * 取得
     * @param issueId 課題ID
     * @return 課題エンティティ
     */
    @Select("select * from issues where id = #{issueId}")
    fun findById(issueId: Long): IssueEntity?

    /**
     * 削除
     * @param issueId 課題ID
     */
    @Delete("delete from issues where id = #{issueId}")
    fun deleteById(issueId: Long)
}
