import java.io.IOException;

public class Server
{
	public static void main(String[] args) throws IOException
	{
		Thread initMasterThread = new Thread();
		Thread initConsoleThread = new Thread();
		Thread initFilterThread = new Thread();

		listen initMaster = new listen();
		initMasterThread = new Thread(initMaster);
		initMasterThread.start();

		Console initConsole = new Console();
		initConsoleThread = new Thread(initConsole);
		initConsoleThread.start();
	}
}