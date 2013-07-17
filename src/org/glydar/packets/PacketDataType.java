package org.glydar.packets;

/**
 * Class of all packet data types
 * @author JohSketch
 */
public class PacketDataType
{
	
	public static final int IntegerSize = 4;
	public static final int FloatSize = 4;
	public static final int LongSize = 8;
	
	private Class<?> dataType;
	
	private int length;
	
	public PacketDataType(Class<?> dataType)
	{
		
		this.dataType = dataType;
		this.length = determinePacketLength(dataType);
		
	}
	
	public PacketDataType(Class<?> dataType, int len)
	{
		this.dataType = dataType;
		length = len;
	}
	
	private static int determinePacketLength(Class<?> clazz)
	{
		
		int len = 0;
		
		if (clazz.isAssignableFrom(Float.class))
		{
			len += FloatSize;
		}
		else if (clazz.isAssignableFrom(Long.class))
		{
			len += LongSize;
		}
		else if (clazz.isAssignableFrom(Integer.class))
		{
			len += IntegerSize;
		}
		else
		{
			return 0;
		}
		
		return len;
		
	}
	
	public Class<?> getDataType()
	{
		return dataType;
	}
	
	public int getLength()
	{
		return length;
	}
	
}
