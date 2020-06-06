package com.course.business.controller.admin;

import com.course.server.dto.SectionDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.exception.ValidatorException;
import com.course.server.service.SectionService;
import com.course.server.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/Section")
public class SectionController {

    private static final Logger LOG = LoggerFactory.getLogger(SectionController.class);

    public static final String BUSINESS_NAME = "小节";

    @Resource
    private SectionService SectionService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        ResponseDto responseDto = new ResponseDto();
        SectionService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody SectionDto SectionDto) {
        LOG.info("SectionDto:{}", SectionDto);

        // 保存校验


        ResponseDto responseDto = new ResponseDto();
        SectionService.save(SectionDto);
        responseDto.setContent(SectionDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        LOG.info("id:{}", id);
        ResponseDto responseDto = new ResponseDto();
        SectionService.delete(id);
        return responseDto;
    }
}
