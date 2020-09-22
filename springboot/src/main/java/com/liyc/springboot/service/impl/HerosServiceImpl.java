package com.liyc.springboot.service.impl;

import com.liyc.springboot.model.Heros;
import com.liyc.springboot.dao.HerosMapper;
import com.liyc.springboot.service.IHerosService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyc
 * @since 2020-09-22
 */
@Service
public class HerosServiceImpl extends ServiceImpl<HerosMapper, Heros> implements IHerosService {

}
