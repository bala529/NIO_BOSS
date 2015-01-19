package nio;

import java.io.Serializable;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int getMessageId() 
	{
		return MessageId;
	}
	
	public void setMessageId(int messageId)
	{
		MessageId = messageId;
	}
	
	public byte[] msg;
	
	public byte[] getMsg()
	{
		return msg;
	}
	
	public void setMsg(byte[] msg) 
	{
		this.msg = msg;
	}
	
	public enum MessageType {HELLO,REQUEST,REPLY,REPLY_REQ,REPLY_HELLO};
	public MessageType type;
	public int MessageId;
	public long nanotime;
	
	public long getNanotime() 
	{
		return nanotime;
	}
	
	public void setNanotime(long nanotime) 
	{
		this.nanotime = nanotime;
	}
	
	public MessageType getType()
	{
		return type;
	}
	public void setType(MessageType type)
	{
		this.type = type;
	}
}
