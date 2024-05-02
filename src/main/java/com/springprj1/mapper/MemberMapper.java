package com.springprj1.mapper;

import com.springprj1.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    @Insert("""
            INSERT INTO member
            (email, password, nick_name)
            VALUES (#{email},#{password},#{nickName})
            """)
    int insert(Member member);
}
