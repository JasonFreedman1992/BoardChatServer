import java.io.IOException;
import java.util.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.net.*;

public class ServerSoftLayerFilter
{
	public listen listen = new listen();
	public ServerData serverData = new ServerData();
	public CharsetEncoder enc = Charset.forName("UTF-8").newEncoder();

	class listen implements Runnable
	{
		public void run()
		{
			while(true)
			{
				try
				{
					Thread.sleep(5000);
					if(serverData.Q.isEmpty())
					{
						System.out.println("server data empty");
					}
					else if(!serverData.Q.isEmpty())
					{
						System.out.println("server data not empty");
						for(int i = 0; i < serverData.Q.size(); i++)
						{
							try
							{
								ServerData.Q.get(i).write(enc.encode(CharBuffer.wrap("p")));
							}
							catch(CharacterCodingException e)
							{
								System.out.println("cc " + e);
							}
							catch(IOException f)
							{
								System.out.println("Io " + f);
								ServerData.Q.remove(i);
							}
						}
					}
				}
				catch(InterruptedException e)
				{

				}
			}
		}
	}
}