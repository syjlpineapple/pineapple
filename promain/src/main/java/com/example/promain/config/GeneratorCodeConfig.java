package com.example.promain.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class GeneratorCodeConfig {

    private static final String dbName = "zhilee";
    private static final String driverClassName = "com.mysql.cj.jdbc.Driver";

    private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";

    private static final String dbUsername = "root";
    private static final String dbPassword = "admin";

    private static final String basePackageName = "com.example.demo";

    private static final String author = "zhilee";

    // 是否开启swagger日志
    private static final boolean useSwagger = false;
    // 是否覆盖
    private static final boolean isOverride = false;

    /**
     * 直接获取数据库中的所有表名然后自动生成
     * 自动生成entity、mapper、service、controller的代码
     *
     * @throws Exception
     */
    private static void generateAllInfo() throws Exception {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setSwagger2(useSwagger);      //实体属性 Swagger2 注解
        gc.setFileOverride(isOverride);  // 是否覆盖
        gc.setServiceName("%sService"); //去Service的I前缀
        mpg.setGlobalConfig(gc);


        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass("com.baomidou.mybatisplus.extension.activerecord.Model");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        strategy.setEntityLombokModel(true);
        // 公共父类
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dbUrl);
        dsc.setDriverName(driverClassName);
        dsc.setUsername(dbUsername);
        dsc.setPassword(dbPassword);
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null);
        pc.setParent(basePackageName);
        mpg.setPackageInfo(pc);

        mpg.execute();
    }

    public static void main(String[] args) {
        try {
            generateAllInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}