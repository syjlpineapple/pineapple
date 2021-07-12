package com.example.promain.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.promain.entity.HttpTestRecord;
import com.example.promain.mapper.HttpTestRecordMapper;
import com.example.promain.service.HttpTestRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 请求你记录表 服务实现类
 * </p>
 *
 * @author zhilee
 * @since 2021-06-26
 */
@Service
public class HttpTestRecordServiceImpl extends ServiceImpl<HttpTestRecordMapper, HttpTestRecord> implements HttpTestRecordService {

}
