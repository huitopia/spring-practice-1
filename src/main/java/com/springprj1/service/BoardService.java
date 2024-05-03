package com.springprj1.service;

import com.springprj1.domain.Board;
import com.springprj1.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    public Map<String, Object> list(Integer page) {
        int offset = (page - 1) * 10;
        int numberOfBoard = mapper.countAll();
        int lastPageNumber = (numberOfBoard - 1) / 10 + 1;
        int endPageNumber = (page - 1) / 10 * 10 + 10;
        int beginPageNumber = endPageNumber - 9;

        endPageNumber = Math.min(endPageNumber, lastPageNumber);

        int prevPageNumber = beginPageNumber - 10;
        int nextPageNumber = beginPageNumber + 10;

        return Map.of("boardList", mapper.selectAllByPage(offset)
                , "pageInfo", Map.of("lastPageNumber", lastPageNumber,
                        "endPageNumber", endPageNumber,
                        "beginPageNumber", beginPageNumber,
                        "prevPageNumber", prevPageNumber,
                        "nextPageNumber", nextPageNumber,
                        "currentPageNumber", page));
    }
}
