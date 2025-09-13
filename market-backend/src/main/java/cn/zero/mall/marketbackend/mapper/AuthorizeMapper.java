package cn.zero.mall.marketbackend.mapper;

import cn.zero.mall.marketbackend.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Zero02
 */
@Mapper
public interface AuthorizeMapper {
    @Select("SELECT * from user where username = #{str} or email = #{str}")
    Admin findAdmin(String str);
}
