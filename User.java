public class User
{
	public java.nio.channels.SocketChannel socket;
	public String address;
	public String username;
	//String remoteAddress;
	//String localAddress;
	//int QNUM;
	//int UNUM;
	User(String p_address, String p_username, java.nio.channels.SocketChannel p_socket)
	{
		address = p_address;
		username = p_username;
		socket = p_socket;
	}
}