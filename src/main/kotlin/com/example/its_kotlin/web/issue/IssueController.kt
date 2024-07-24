package com.example.its.web.issue

import com.example.its.domain.issue.IssueService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

/**
 * 課題コントローラ
 */
@Controller
@RequestMapping("/issues")
class IssueController(private val issueService: IssueService) {

    /**
     * 一覧表示
     * @param model モデル
     * @return 遷移先
     */
    @GetMapping
    fun showList(model: Model): String {
        val list = issueService.findAll()
        model.addAttribute("issueList", list)
        return "issues/list"
    }

    /**
     * 登録フォーム表示
     */
    @GetMapping("creationForm")
    fun showCreationForm(@ModelAttribute form: IssueForm): String {
        return "issues/creationForm"
    }

    /**
     * 登録処理（PRGパターン）
     * @param form 課題フォーム
     * @param model モデル
     * @return 遷移先
     */
    @PostMapping
    fun create(
        @Validated form: IssueForm,
        bindingResult: BindingResult,
        model: Model
    ): String {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form)
        }

        issueService.create(form.summary, form.description)
        return "redirect:/issues"
    }

    /**
     * 削除（PRGパターン）
     * @param issueId 課題ID
     * @return 遷移先
     */
    @PostMapping("/delete/{issueId}")
    fun delete(@PathVariable("issueId") issueId: Long): String {
        issueService.delete(issueId)
        return "redirect:/issues"
    }

    /**
     * 詳細表示
     * @param issueId 課題ID
     * @param model モデル
     * @return 遷移先
     */
    @GetMapping("/{issueId}")
    fun showDetail(@PathVariable("issueId") issueId: Long, model: Model): String {
        val data = issueService.findById(issueId)
        model.addAttribute("issue", data)
        return "issues/detail"
    }
}
