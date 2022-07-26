package com.yanggy.user.mapper;

import com.yanggy.user.entity.Menu;
import com.yanggy.user.param.MenuParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yangguiyun on 2017/10/21.
 */
@Component
@Mapper
public interface MenuMapper {

    List<Menu> getAllMenus(MenuParam menu);
    List<Menu> getAllMenusByParent(@Param("parentId") Long parentId);
    Menu getMenuById(@Param("id") Long id);

    int countMenus(MenuParam menu);
}
