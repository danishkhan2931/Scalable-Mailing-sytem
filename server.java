//server class
class Server {
    int NO_OF_THREAD=100;
    //every server will have equal no of thread with thread id between 0 to 99 
	SendToServerThread thread[NO_OF_THREAD];
	int serverId;
	//unique server id which will start from 0 and will be different for different server
	public Server(string username,string password) {
		for(i=0;i<NO_OF_THREAD;i++) {
		    //get function return EmailDao Data  from common data host  
			Info info = get(address_of_common_to_all_server_data_host).(EmailDAO.getInstance().getInfo())
			serverId = info.getNoOfServer();
			int currentIndex = info.getIndex();
			thread[i]=new SendToServerThread(string username,string username ,currentIndex, serverId);
		}
		
		for(i=0;i<NO_OF_THREAD;i++)
		{
			thread[i].start();
		}
		
		
	}
}