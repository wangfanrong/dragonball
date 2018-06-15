package com.dragonball.web.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.dragonball"})
@MapperScan(value = "com.dragonball.dao")
public class DragonBallWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DragonBallWebApiApplication.class, args);
		System.out.println("ヾ(◍°∇°◍)ﾉﾞ    dragonball启动成功      ヾ(◍°∇°◍)ﾉﾞ\n" +
				"       _                             _           _ _ \n" +
				"     | |                           | |         | | |\n" +
				"   __| |_ __ __ _  __ _  ___  _ __ | |__   __ _| | |\n" +
				"  / _` | '__/ _` |/ _` |/ _ \\| '_ \\| '_ \\ / _` | | |\n" +
				" | (_| | | | (_| | (_| | (_) | | | | |_) | (_| | | |\n" +
				"  \\__,_|_|  \\__,_|\\__, |\\___/|_| |_|_.__/ \\__,_|_|_|\n" +
				"                   __/ |                            \n" +
				"                  |___/                              ");
	}
}
