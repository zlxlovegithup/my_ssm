package com.zlx.my_ssm.dao;

import com.zlx.my_ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * 会员的持久层接口
 */
public interface IMemberDao {
    /**
     * 根据memberId查询会员
     * @param memberId
     * @return
     */
    @Select("select * from member where id = #{memberId}")
    Member findMemberById(String memberId) throws Exception;
}
