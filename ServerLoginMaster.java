import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class ServerLoginMaster
{
	private ServerSocket listener;
	final public static int MAX_CLIENTS = 100;
	final private LinkedList<SubServer> Q = new LinkedList<SubServer>();
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
					Socket next;
					next = listener.accept();
					if(next.isBound())
					{
						Q.add(new SubServer(next));
					}
					next = null;
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