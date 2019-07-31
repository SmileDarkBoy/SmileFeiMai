package cn.superbio.judicial.cloud.biz.finance.autoconfigure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.superbio.judicial.cloud.biz.finance.mapper*")
@ComponentScan(basePackages = {"cn.superbio.judicial.cloud.biz.finance.provider", "cn.superbio.judicial.cloud.biz.finance.service"})
public class BizFinanceAutoConfiguration {
}
