public static int min(){
	if(front == null){
	   throw new NoSuchElementException();
	} else {
	   int min = front.data;
	   ListNode current = front.next;
	
	   while(current != null){
	      if(current.data < min){
	   	 min = current.data;   
	      }
	   	 current = current.next;
	   }
	return min;
	}
}

