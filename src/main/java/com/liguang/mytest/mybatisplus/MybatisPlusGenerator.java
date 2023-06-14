package com.liguang.mytest.mybatisplus;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 描述:
 *
 * @author fairy
 * @date 2023/6/14 11:03
 */
public class MybatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://172.19.26.22:3306/sbc-bff?useUnicode=true&characterEncoding=UTF8&useSSL=false", "root", "Wmi@2023")
                // 全局配置
                .globalConfig((scanner, builder) ->
                        builder.outputDir(System.getProperty("user.dir").concat("/src/main/java")) // 生成文件输出目录
                                .fileOverride() // 覆盖已有文件
                                .author("李广") // 作者名称
                                .enableSwagger() // 开启swagger
                                .commentDate("YYYY-HH-DD hh:mm:ss") //配置时间类型格式
                                .disableOpenDir()) // 禁止打开文件夹
                // 包配置
                .packageConfig((scanner, builder) ->
                        builder.parent("com.liguang.mytest.db") // 配置父包路径
                                .pathInfo(MapUtil.<OutputFile, String>builder()
                                        .put(OutputFile.mapperXml, System.getProperty("user.dir").concat("/src/main/resources/mappers"))
                                        .put(OutputFile.controller, System.getProperty("user.dir").concat("/src/main/java/com/liguang/mytest/db"))
                                        .build()
                                ))
                // 策略配置
                .strategyConfig((scanner, builder) ->
                        builder.addInclude("student") // 需要生成的表名城管
                                // 实体类配置
                                .entityBuilder()
                                .enableLombok() // 开启lombok
                                .idType(IdType.AUTO) // 设置主键自增
                                .enableChainModel() // 采用链式
                                .enableTableFieldAnnotation() // 字段注解
                                // controller 配置
                                .controllerBuilder()
                                .enableRestStyle() // 开始restController 方式
                                .enableHyphenStyle() // 开始驼峰方式
                                // mapper 配置
                                .mapperBuilder()
                                // service 配置
                                .serviceBuilder())
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
