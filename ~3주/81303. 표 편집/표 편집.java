// import java.util.*;
// class Solution {
//     public String solution(int n, int k, String[] cmd) {
//         /**
//         linked list?
//         */
//         String answer = "";
// //         HashMap<Integer, Element> map = new HashMap<>();
        
// //         for(int idx = 0; idx < n; idx++){
// //             if(idx == n -1){
// //                 map.put(idx, new Element(idx -1, -1, idx));
// //                 continue;
// //             }
// //             map.put(idx, new Element(idx -1, idx + 1, idx));
// //         }
// //         map.put(-1, new Element(-1, -1, -1));
        
        
//         Element[] list = new Element[n + 1];
//         int curPos = k;
//         ArrayDeque<Element> queue = new ArrayDeque<>();
//         for(String c : cmd){
//             if(c.length() == 1){
//                 if(c.charAt(0) == 'C'){
//                     Element cur = list[curPos];
//                     int front = cur.front;
//                     int tail = cur.tail;
//                     int name = cur.name;
//                     if(tail != -1){
//                         curPos = tail;
//                         Element fr = map.get(front);
//                         Element end = map.get(tail);
//                         fr.setTail(tail);
//                         end.setFront(front);
//                         map.put(front, fr);
//                         map.put(tail, end);
                        
//                     }else{
//                         curPos = front;
//                         Element fr = map.get(front);
//                         fr.setTail(-1);
//                         map.put(front, fr);
//                     }
                    
//                     queue.add(cur);
                    
//                 }
//                 if(c.charAt(0) == 'Z'){
//                     if(queue.isEmpty()){
//                         continue;    
//                     }
//                     Element cur = queue.pollLast();
//                     Element fr = map.get(cur.front);
//                     Element end = map.get(cur.tail);
                    
//                     fr.setTail(cur.name);
//                     end.setFront(cur.name);
                    
//                     map.put(cur.front, fr);
//                     map.put(cur.tail, end);
//                     cur.setDelete(false);
//                     map.put(cur.name, cur);
//                 }
                
                
//             }else{
//                 if(c.charAt(0) == 'U'){
//                     int idx = 0; 
//                     // System.out.println("UP");
//                     int target = Integer.parseInt(c.split(" ")[1]);
//                     while(idx < target){
//                         curPos = map.get(curPos).front;
//                         idx++;
//                     }
//                 }
//                 if(c.charAt(0) == 'D'){
//                     int idx = 0; 
//                     // System.out.println("Down");
//                     int target = Integer.parseInt(c.split(" ")[1]);
//                     while(idx < target){
//                         curPos = map.get(curPos).tail;
//                         idx++;
//                     }
//                 }
                
                
                
//             }
//             // System.out.println( c + " curPos: " + curPos);
//             // System.out.println(map.toString());
//             // System.out.println(queue.toString());
            
            
            
            
            
//         }
        
        
        
        
        
        
        
        
//         return answer;
//     }
//     class Element{
//         int front;
//         int tail;
//         int name;
//         boolean isDelete;
//         Element(int front, int tail, int name){
//             this.front = front;
//             this.tail = tail;
//             this.name = name;
//             this.isDelete = false;
//         }
        
//         void setFront(int front){
//             this.front = front;
//         }
        
//         void setTail(int tail){
//             this.tail = tail;
//         }
//         void setDelete(boolean delete){
//             this.isDelete = delete;
//         }
//         @Override
//         public String toString(){
//             return "["+this.front + " " + this.name + " " + this.tail + "]";
//         }
        
//     }
// }


import java.util.Stack;

public class Solution {

    private static final char UP = 'U';
    private static final char DOWN = 'D';
    private static final char CLEAR = 'C';
    private static final char RESTORE = 'Z';
    
    public String solution(int n, int k, String[] cmd) {
        Stack<Node> deletedRows = new Stack<>();
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();

            if (i == 0) {
                continue;
            }

            nodes[i - 1].next = nodes[i];
            nodes[i].prev = nodes[i - 1];
        }

        Node current = nodes[k];

        for (String command : cmd) {
            char operation = command.charAt(0);

            switch (operation) {
                case UP:
                    int movement = Integer.parseInt(command.split(" ")[1]);
                    current = current.movePrev(movement);
                    break;
                case DOWN:
                    movement = Integer.parseInt(command.split(" ")[1]);
                    current = current.moveNext(movement);
                    break;
                case CLEAR:
                    deletedRows.add(current);
                    current = current.delete();
                    break;
                case RESTORE:
                    Node node = deletedRows.pop();
                    node.restore();
                    break;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nodes[i].removed) {
                answer.append("X");
                continue;
            }
            answer.append("O");
        }

        return answer.toString();
    }

    class Node {
        Node prev = null;
        Node next = null;
        boolean removed;

        public Node movePrev(int movement) {
            Node node = this;
            for (int i = 0; i < movement; i++) {
                node = node.prev;
            }

            return node;
        }

        public Node moveNext(int movement) {
            Node node = this;
            for (int i = 0; i < movement; i++) {
                node = node.next;
            }

            return node;
        }

        public Node delete() {
            this.removed = true;
            Node prev = this.prev;
            Node next = this.next;

            if (prev != null) {
                prev.next = next;
            }

            if (next != null) {
                next.prev = prev;
                return next;
            }

            return prev;
        }

        public void restore() {
            this.removed = false;
            Node prev = this.prev;
            Node next = this.next;

            if (prev != null) {
                prev.next = this;
            }

            if (next != null) {
                next.prev = this;
            }
        }
    }
}