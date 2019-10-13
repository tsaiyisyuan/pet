package com.tw.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//使用@SpringBootApplication注解等於使用@Configuration，@EnableAutoConfiguration和@ComponentScan。
//@Configuration，表示這個類別是用來做為 spring設定。
//@EnableAutoConfiguration，啟用 SpringBoot自動配置，將自動判斷專案使用到的套件，建立相關的設定。
//@ComponentScan，自動掃描 SpringBean元件
@SpringBootApplication
//掃瞄com111底下的所有package裡面有annotation的都做
@ComponentScan({"com.*"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
