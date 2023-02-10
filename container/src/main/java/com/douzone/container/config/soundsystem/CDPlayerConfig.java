package com.douzone.container.config.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.douzone.container.soundsystem"}) //스캐닝 활성화 component 달고 있으면 생성
public class CDPlayerConfig {

}
