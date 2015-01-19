package nio;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;

/**
 * Handles a server-side channel.
 */
public class handler extends ChannelInboundHandlerAdapter
{ 
	
	private final ByteBuffer lengthByteBuffer = ByteBuffer.wrap(new byte[4]);
	private ByteBuffer dataByteBuffer = null;
	private boolean readLength = true;

	public void channelRead(ChannelHandlerContext ctx, Object msg) throws IOException, ClassNotFoundException 
	{  
		
		
		// ByteBuf recv = (ByteBuf) msg;
		ByteBuffer lengthByteBuffer = (ByteBuffer) msg;
		//if (dataByteBuffer.remaining() == 0) 
		//{
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(dataByteBuffer.array()));
            Message dummy = (Message) ois.readObject();
            System.out.println(dummy.getMessageId());
		//}
		 
         
	    
	}
         
    

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) 
    { 
        
        cause.printStackTrace();
        ctx.close();
    }
}
