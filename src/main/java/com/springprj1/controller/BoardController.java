package com.springprj1.controller;

import com.springprj1.domain.Board;
import com.springprj1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    @GetMapping("/add")
    public String add() {
        return "board/add";
    }

    @PostMapping("/add")
    public String addPost(Board board) {
        // form 에서 값 넘어왔는지 확인

        service.add(board);
        return "redirect:/board?id=" + board.getId();
    }

    @GetMapping("/board")
    public String view(Integer id, Model model) {
        // 게시물 조회
        Board board = service.get(id);
        // 모델에 넣고
        model.addAttribute("board", board);

        // jsp 포워드
        return "board/view";
    }

    @GetMapping("/")
    public String home(@RequestParam(value = "page", defaultValue = "1") Integer page,
                       Model model) {
        // 게시물 목록 조회(select)
        // 모델에 넣고
        model.addAllAttributes(service.list(page));
        // jsp로 포워드
        return "board/home";
    }

    @PostMapping("/delete")
    public String delete(Integer id) {
        service.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/modify")
    public String modifyForm(Integer id, Model model) {
        model.addAttribute("board", service.get(id));
        return "board/modify";
    }

    @PostMapping("/modify")
    public String modifyPost(Board board) {
        service.modifyById(board);
        return "redirect:/board?id=" + board.getId();
    }
}
