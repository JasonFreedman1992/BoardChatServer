import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class ServerLoginMaster
{
	public ServerData serverData = new ServerData();
	private ServerSocket listener;
	public listen listen = new listen();

	public ServerLoginMaster(int p_port) throws IOException
	{
		listener = new ServerSocket(p_port);
	}

	class listen implements Runnable
	{
		public void run()
		{
			while(true)
			{
				try
				{
					if(!serverData.softLogins.isEmpty())
					{
						for(int i = 0; i < serverData.softLogins.size(); i++)
						{
							System.out.println(serverData.softLogins.get(i).getRemoteSocketAddress());
							Thread.sleep(1000);
						}
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
	}

	class SubServer
	{
		Socket socket;
		public SubServer(Socket p_socket)
		{
			socket = p_socket;
		}
		//ServerProcess process = new ServerProcess(next);
	}
}