package com.springprj1.controller;

import com.springprj1.domain.Member;
import com.springprj1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    private final MemberService service;

    @GetMapping("signup")
    public String signupForm() {
        return "member/signup";
    }

    @PostMapping("signup")
    public String signup(Member member) {
        service.signup(member);
        return "redirect:/";
    }

    @GetMapping("list")
    public String memberList(Model model) {
        model.addAttribute("memberList", service.list());
        return "member/list";
    }

    @GetMapping("")
    public String info(Integer id, Model model) {
        model.addAttribute("memberInfo", service.getInfo(id));
        return "member/info";
    }

    @PostMapping("remove")
    public String remove(Integer id) {
        service.deleteMemberById(id);
        return "redirect:/";
    }

    @GetMapping("modify")
    public String modifyInfo(Integer id, Model model) {
        model.addAttribute("memberInfo", service.getInfo(id));
        return "member/modify";
    }

    @PostMapping("modify")
    public String modify(Member member) {
        service.updateInfoById(member);
        return "redirect:/member/list";
    }

    @GetMapping("email")
    @ResponseBody
    public String emailCheck(String email) {
        String message = service.emailCheck(email);
        return message;
    }
}
