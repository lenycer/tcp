package me.lenycer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import me.lenycer.netty.ServiceHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TcpApplicationTests {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void serverTest01() {
		String message = "Test";
		EmbeddedChannel ch = new EmbeddedChannel(new ServiceHandler());
		ByteBuf in = Unpooled.wrappedBuffer(message.getBytes());
		ch.writeInbound(in);
		ByteBuf out = ch.readOutbound();
		logger.info("result : {}",out.toString(Charset.defaultCharset()));
	}

}
