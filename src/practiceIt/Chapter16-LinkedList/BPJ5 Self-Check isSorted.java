public static boolean isSorted(){
	ListNode pre = front;
	if(front == null){
	   return true;
	}
	while(pre.next != null){
	   ListNode current = pre.next;
	   if(current.data < pre.data) {
		return false;
	}
	pre = current;
   }
   return true;
}
