package com.springprj1.controller;

import com.springprj1.domain.Member;
import com.springprj1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @PreAuthorize("hasAuthority('admin')")
//    어드민 권한이 있을때만
    public String list(Model model) {
        model.addAttribute("memberList", service.list());
        return "member/list";
    }

    @GetMapping("")
    // 본인 정보 또는 어드민 권한만 실행
    public String info(Integer id,
                       Model model,
                       Authentication authentication) {
        if (service.hasAccess(id, authentication) || service.isAdmin(authentication)) { // 권한이 있을 때만
            model.addAttribute("member", service.get(id));
            return "member/info";
        } else { // 권한 없으면 home
            return "redirect:/";
        }
    }

    @PostMapping("remove")
    public String remove(Integer id, Authentication authentication) {
        if (service.hasAccess(id, authentication)) {
            service.remove(id);
        }

        return "redirect:/logout";
    }

    @GetMapping("modify")
    public String modifyForm(Integer id, Model model) {
        model.addAttribute("member", service.get(id));

        return "member/modify";
    }

    @PostMapping("modify")
    public String modify(Member member, RedirectAttributes rttr, Authentication authentication) {
        if (service.hasAccess(member.getId(), authentication)) {
            service.modify(member);
        }

        rttr.addAttribute("id", member.getId());
        return "redirect:/member";
    }

    @GetMapping("email")
    @ResponseBody
    public String emailCheck(String email) {
        System.out.println("email = " + email);
        String message = service.emailCheck(email);
        return message;
    }

    @GetMapping("login")
    public String loginForm() {
        return "member/login";
    }
}