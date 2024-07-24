package com.example.its.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * トップページコントローラ
 */
@Controller
class IndexController {

    /**
     * トップページ
     * @return 遷移先
     */
    @GetMapping
    fun index(): String {
        return "index"
    }
}