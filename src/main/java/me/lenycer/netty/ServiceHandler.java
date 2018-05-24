package me.lenycer.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * Created by a1100440 on 2018. 5. 2..
 */
public class ServiceHandler extends ChannelInboundHandlerAdapter {

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Channel active.
     *
     * @param ctx the ctx
     * @throws Exception the exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("Active");
    }

    /**
     * Channel read.
     *
     * @param ctx the ctx
     * @param msg the msg
     * @throws Exception the exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = (String) msg;
        logger.debug("message : {} ",message);
        ctx.channel().writeAndFlush("A|TEST|11").addListener(future -> {
            if(future.isSuccess()) {
                logger.info("success");
            } else {
                logger.info("fail");
            }
        });
    }
}
