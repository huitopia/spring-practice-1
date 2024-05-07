package com.springprj1.service;

import com.springprj1.domain.CustomUser;
import com.springprj1.domain.Member;
import com.springprj1.mapper.BoardMapper;
import com.springprj1.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper mapper;
    private final BoardMapper boardMapper;
    private final BCryptPasswordEncoder encoder;

    public void signup(Member member) {
        member.setPassword(encoder.encode(member.getPassword()));

        mapper.insert(member);
    }

    public List<Member> list() {
        return mapper.selectAll();
    }

    public Member get(Integer id) {
        return mapper.selectById(id);
    }

    public void remove(Integer id) {
        // board 테이블에서 레코드 삭제
        boardMapper.deleteBoardByMemberId(id);
        // member 테이블에서 레코드 삭제
        mapper.deleteById(id);
    }

    public void modify(Member member) {
        if (member.getPassword() != null & member.getPassword().length() > 0) {
            // 암호를 입력했을 때만 변경
            member.setPassword(encoder.encode(member.getPassword()));
        } else {
            // 기존 암호 유지
            Member old = mapper.selectById(member.getId());
            member.setPassword(old.getPassword());
        }
        mapper.update(member);
    }

    public String emailCheck(String email) {
        Member member = mapper.selectByEmail(email);
        if (member == null) {
            // 사용 가능한 이메일
            return "사용 가능한 이메일입니다.";
        } else {
            // 이미 존재하는 이메일
            return "이미 존재하는 이메일입니다.";
        }
    }

    public boolean hasAccess(Integer id, Authentication authentication) {
        if (authentication == null) {
            return false;
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUser user) {
            Member member = user.getMember();
            return member.getId().equals(id);
        }
        return false;
    }

    public boolean isAdmin(Authentication authentication) {
        Object o = authentication.getPrincipal();
        if (o instanceof CustomUser user) {
            // 갖고 있는 권한중에 하나라도 admin 이면 true, 아니면 false
            return user.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(s -> s.equals("admin"));
        }
    }
}