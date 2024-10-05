//clark john tapales  BSCS 2A 10-5-24 
class NodeList{

   class Node {
      Object data;
      Node tail;

      Node(String data) {
         this.data = data;
         this.tail = null;
      }
   }

   private  Node head;
   private int counter;
   
   public NodeList(){
      this.head = null;
      this.counter = 0;
   }

   public boolean isEmpty(){
      return counter == 0;
   }
   
   public boolean add(Node item){
      item.tail = head;
      head = item;
      counter++;
      return true; 
   }
   
   public boolean delete(int location){
      if (isEmpty() || location < 0 || location >= counter) {
         System.out.println("Out of Bounds");
         return false;        
      }
      if (location == 0) { 
         head = head.tail;
         counter--;
         return true;
      }
      
      Node current = head;
      
      for (int i = 0; i < location - 1; i++)
         current = current.tail;
         
      if(current.tail != null){
         current.tail = current.tail.tail;
         counter--;
         return true;
      }
      return false;
   }
   public void display() {
      if(!isEmpty()) {
         Node temporary = head;
         int indexCount = 0;
         while(temporary != null){
            System.out.println("[" + temporary.data + "], Index Count:  " + indexCount++);
            temporary = temporary.tail;
         }
         System.out.println();
      }else {
         System.out.println("NodeList is empty....");
      }
   }   
}


public class TestNodeList {
    public static void main(String[] args) {
        NodeList list = new NodeList(); 
         
        list.add(list.new Node("Node 1"));
        list.add(list.new Node("Node 2"));
        list.add(list.new Node("Node 3"));
        list.add(list.new Node("Node 4"));
        list.display();
        
        list.delete(2);
        list.display();
        
        list.delete(1);
        list.display();
             
   }
}