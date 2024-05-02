package com.springprj1.service;

import com.springprj1.domain.Board;
import com.springprj1.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BoardService {
    private final BoardMapper mapper;

    public void add(Board board) {
        mapper.insert(board);
    }

    public Board get(Integer id) {
        return mapper.selectById(id);
    }

    public List<Board> list() {
        return mapper.selectAll();
    }

    public void deleteById(Integer id) {
        mapper.deleteById(id);
    }

    public void modifyById(Board board) {
        mapper.modifyById(board);
    }
}
