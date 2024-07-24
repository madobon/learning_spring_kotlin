package com.example.its.web.issue

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

/**
 * 課題フォーム
 * @param summary
 * @param description
 */
data class IssueForm(
    @field:NotBlank @field:Size(max = 256) val summary: String,
    @field:NotBlank @field:Size(max = 256) val description: String
)