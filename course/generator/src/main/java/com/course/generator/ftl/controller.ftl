package com.course.business.controller.admin;

import com.course.server.dto.${Domain}Dto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.exception.ValidatorException;
import com.course.server.service.${Domain}Service;
import com.course.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/${Domain}")
public class ${Domain}Controller {

    private static final Logger LOG = LoggerFactory.getLogger(${Domain}Controller.class);

    public static final String BUSINESS_NAME = "大章";

    @Resource
    private ${Domain}Service ${Domain}Service;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        ${Domain}Service.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody ${Domain}Dto ${Domain}Dto) {
        LOG.info("${Domain}Dto:{}", ${Domain}Dto);

        // 保存校验


        ResponseDto responseDto = new ResponseDto();
        ${Domain}Service.save(${Domain}Dto);
        responseDto.setContent(${Domain}Dto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        LOG.info("id:{}", id);
        ResponseDto responseDto = new ResponseDto();
        ${Domain}Service.delete(id);
        return responseDto;
    }
}
