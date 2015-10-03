class Assignment
{
	public static void main()
	{
		string username;
		string password;
		
         Scanner in = new Scanner(System.in);
	     username = in.nextLine();
	    password= in.nextLine();
	    Server server=new Server(username, password);
		
		
		
		
	}
}