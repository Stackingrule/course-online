package com.course.server.service;

import com.course.server.domain.Section;
import com.course.server.domain.SectionExample;
import com.course.server.dto.SectionDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.SectionMapper;
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
public class SectionService {

    @Resource
    private SectionMapper SectionMapper;

    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        SectionExample SectionExample = new SectionExample();
        List<Section> SectionList = SectionMapper.selectByExample(SectionExample);
        PageInfo<Section> pageInfo = new PageInfo<>(SectionList);
        pageDto.setTotal(pageInfo.getTotal());
        List<SectionDto> SectionDtoList = new ArrayList<SectionDto>();
        for (int i = 0; i < SectionList.size(); i++) {
            Section Section = SectionList.get(i);
            SectionDto SectionDto = new SectionDto();
            BeanUtils.copyProperties(Section, SectionDto);
            SectionDtoList.add(SectionDto);
        }
        pageDto.setList(SectionDtoList);
    }

    public void save(SectionDto SectionDto) {
        Section Section = CopyUtil.copy(SectionDto, Section.class);
        if (StringUtils.isEmpty(SectionDto.getId())) {
            this.insert(Section);
        }
        else {
            this.update(Section);
        }
    }

    private void insert(Section Section) {
        Section.setId(UuidUtil.getShortUuid());
        SectionMapper.insert(Section);
    }

    private void update(Section Section) {
        SectionMapper.updateByPrimaryKey(Section);
    }

    public void delete(String id) {
        SectionMapper.deleteByPrimaryKey(id);
    }

}
