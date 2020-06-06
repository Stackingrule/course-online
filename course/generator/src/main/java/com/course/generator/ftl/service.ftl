package com.course.server.service;

import com.course.server.domain.${Domain};
import com.course.server.domain.${Domain}Example;
import com.course.server.dto.${Domain}Dto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.${Domain}Mapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ${Domain}Service {

    @Resource
    private ${Domain}Mapper ${Domain}Mapper;

    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        ${Domain}Example ${Domain}Example = new ${Domain}Example();
        List<${Domain}> ${Domain}List = ${Domain}Mapper.selectByExample(${Domain}Example);
        PageInfo<${Domain}> pageInfo = new PageInfo<>(${Domain}List);
        pageDto.setTotal(pageInfo.getTotal());
        List<${Domain}Dto> ${Domain}DtoList = new ArrayList<${Domain}Dto>();
        for (int i = 0; i < ${Domain}List.size(); i++) {
            ${Domain} ${Domain} = ${Domain}List.get(i);
            ${Domain}Dto ${Domain}Dto = new ${Domain}Dto();
            BeanUtils.copyProperties(${Domain}, ${Domain}Dto);
            ${Domain}DtoList.add(${Domain}Dto);
        }
        pageDto.setList(${Domain}DtoList);
    }

    public void save(${Domain}Dto ${Domain}Dto) {
        ${Domain} ${Domain} = CopyUtil.copy(${Domain}Dto, ${Domain}.class);
        if (StringUtils.isEmpty(${Domain}Dto.getId())) {
            this.insert(${Domain});
        }
        else {
            this.update(${Domain});
        }
    }

    private void insert(${Domain} ${Domain}) {
        ${Domain}.setId(UuidUtil.getShortUuid());
        ${Domain}Mapper.insert(${Domain});
    }

    private void update(${Domain} ${Domain}) {
        ${Domain}Mapper.updateByPrimaryKey(${Domain});
    }

    public void delete(String id) {
        ${Domain}Mapper.deleteByPrimaryKey(id);
    }

}
