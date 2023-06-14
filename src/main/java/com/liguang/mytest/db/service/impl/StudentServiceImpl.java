package com.liguang.mytest.db.service.impl;

import com.liguang.mytest.db.entity.Student;
import com.liguang.mytest.db.mapper.StudentMapper;
import com.liguang.mytest.db.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 李广
 * @since 2023-17-165 05:16:51
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
