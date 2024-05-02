package com.springprj1.service;

import com.springprj1.domain.Member;
import com.springprj1.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper mapper;

    public void signup(Member member) {
        mapper.insert(member);
    }

    public List<Member> list() {
        return mapper.selectAll();
    }

    public Member getInfo(Integer id) {
        return mapper.selectById(id);
    }
}
