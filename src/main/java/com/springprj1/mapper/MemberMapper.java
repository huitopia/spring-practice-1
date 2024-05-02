package com.springprj1.mapper;

import com.springprj1.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Insert("""
            INSERT INTO member
            (email, password, nick_name)
            VALUES (#{email},#{password},#{nickName})
            """)
    int insert(Member member);

    @Select("""
            SELECT * FROM member ORDER BY id DESC
            """)
    List<Member> selectAll();

    @Select("""
            SELECT * FROM member WHERE id = #{id}
            """)
    Member selectById(Integer id);

    @Delete("""
            DELETE FROM member
            WHERE id = #{id}
            """)
    int deleteMemberById(Integer id);

    @Update("""
            UPDATE member
            SET password = #{password}, nick_name = #{nickName}
            WHERE id = #{id}
            """)
    int updateInfoById(Member member);
}
