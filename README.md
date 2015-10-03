# Scalable-Mailing-sytem

Common data to all server:

1) the data base where all mailing  data is present.

2)an integer which tells the number of server connected  integer is in EmailDAO class 

3)an Array list which list which stores an integer corresponding to the segment covered this is in EmailDAO class 




About Central databse:

the data base has an primary key id which starts with 1 and increment by 1 hence each row will have an id like

id=1 for row 1

id=2 for row 2

id =3 for row 3

Logically i have divided the db into segment of 1000 rows





Server:
All server has an unique server id 

Suppose there are number_of_server=2 server connected to the Database then one server has server_id=0 and the second server_id=1

 and if another server try to add to the DB then it's server id =Number_of_server(the common to all integer which is synched so that multiple server can connect at same instant)
so the server_id in our case will be 2 for the third server.



Thread in the server.

Each server  has N=100 number of thread and each thread has a thread id from 0 to N-1 and it's only unique with in a server.

Each thread has a local Array list of Mail object .Mail object corresponds to one row of database table.




Central array list corresponding to the segment number.(EmailDao class)

This contain an integer which corresponds to till which segment we have to search for rows.

every thread has a current index which is it's current index in the list which is  Common to all server 


So the segment number for the thread will be 

  segment = list[current index-1]+ serverId*NO_OF_THREAD + threadId;
  
   
so the id of row that has will be fetch by this thread is 

start = (segment-1)*1000+1  

end = segment*1000

