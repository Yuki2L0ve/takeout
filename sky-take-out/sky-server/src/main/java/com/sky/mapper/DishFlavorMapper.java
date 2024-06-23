package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    /**
     * 向菜品口味表中批量插入数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);
}
