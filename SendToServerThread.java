package com.journaldev.mail; 
import java.util.Properties; 
import javax.mail.Session;


//thread class to fetch mail in an array list and send mail
//In every server there will be same number of thread all of 
//it's thread will have same server id
import EmailDao;
class SendToServerThread implements runable
{
 
  int serverId,threadId;
  int currentIndex;
  //this is the current index of this thread for the centralized array list
  ArrayList<Mail >list;
  //for storing data each thread will have it's own list which will be independent with other thread
  sendtosever(string username,string password,int serverId, int threadId) {
    this.serverId=serverId;
    this.threadId=threadId;
    SMTPMailSender SMTPMailSender=new SMTPMailSender();
    ConnectionCentralDB db=new ConnectionCentralDB(username,password);
    }
  public void run() {
  	while(1){
    //fetch data
    //get function return EmailDao Data  from common data host  
    list = get(address_of_common_to_all_server_data_host).EmailDao.getEmailData(serverId, threadId, currentIndex ,db);
    if(list!=NULL)currentIndex++;
    int i;
    for(i=0,i<list.size();i++) {
   	  //send message
   	  SMTPMailSender.getInstance().sendEmail(list[i].getSender(), list[i].getReciever(), list[i].getMessage());
    }
  }
}
}