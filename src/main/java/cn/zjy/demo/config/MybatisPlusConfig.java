package cn.zjy.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.zjy.demo.dao")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor getPaginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        // 设置数据库方言类型
        page.setDialectType("mysql");
        return page;
    }
}
