package me.lenycer;

import me.lenycer.netty.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TcpApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TcpApplication.class, args);
		context.getBean(NettyServer.class).start();
	}
}
