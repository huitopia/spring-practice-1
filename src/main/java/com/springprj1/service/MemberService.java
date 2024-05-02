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

    public void deleteMemberById(Integer id) {
        mapper.deleteMemberById(id);
    }

    public void updateInfoById(Member member) {
        mapper.updateInfoById(member);
    }

    public String emailCheck(String email) {
        Member member = mapper.selectByEmail(email);
        if (member == null) {
            return "사용 가능";
        } else {
            return "이미 존재";
        }
    }
}
