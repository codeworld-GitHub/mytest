package com.liguang.mytest.db.controller;


import com.liguang.mytest.db.entity.Student;
import com.liguang.mytest.db.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 李广
 * @since 2023-17-165 05:16:51
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/getAllStudents")
    public List<Student> students() {
        return studentService.list();
    }
}
