//centralized class to fetch data for each thread
//this class will be common to all the servers
//here we have a cenrtalized ArrayList which stores 
//the total segment covered till that point
class EmailDAO {
  private final int NO_OF_THREAD = 3;
  private final int NO_OF_EMAIL = 1000;
  private int noOfServer;
  ArrayList<int >totalsegmentcovered;
  //to get current status info
  public synchronized Info getInfo () {
  	return new Info(noOfServer, q.size());
  	noOfServer++;
  }
  EmailDAO obj = null;
  private EmailDAO() {
  	
  }
  static EmailDAO getInstance() {
  	if(obj==null)
  	  return new EmailDAO();
    else
      return obj;
  }
  //method to fetch data and return as an ArrayList
  public ArrayList<Mail > getEmailData(int serverId, int threadId, int currentIndex,ConnectionCentralDB db) {
  	int total_segment_covered;
    if(currentIndex>0) {
    	total_segment_covered = totalsegmentcovered[currentIndex-1];
    	if(totalsegmentcovered.size()<currentIndex+1) {
      		totalsegmentcovered.add(totalsegmentcovered[totalsegmentcovered.size()-1]+No_OfServer*NO_OF_THREAD);
	    }
    }
    else {
  		total_segment_covered = 0;
    	if(totalsegmentcovered.size()<currentIndex+1) {
      		totalsegmentcovered.add(totalsegmentcovered[totalsegmentcovered.size()-1]+No_OfServer*NO_OF_THREAD);
	    }
    }
    int segment = total_segment_covered + serverId*NO_OF_THREAD + threadId;
    return db.query((segment-1)*NO_OF_EMAIL+1, segment*NO_OF_EMAIL);
  }
}