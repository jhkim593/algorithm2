package programmers;

import java.lang.reflect.Array;
import java.util.*;

class 표편집innerClass {

    class Node{
        Node pre;
        Node next;
        boolean isLive;
    }
    Node[] nodeArr=new Node[1000000];
    public String solution(int n, int k, String[] cmd) {
        Stack<Node> stack=new Stack<>();
        for(int i=0;i<n;i++){
            Node temp=new Node();
            temp.isLive=true;
            nodeArr[i]=temp;

        }
        for(int i=1;i<n;i++){
            nodeArr[i-1].next=nodeArr[i];
            nodeArr[i].pre=nodeArr[i-1];
        }

        Node cur=nodeArr[k];

        for(int i=0;i<cmd.length;i++){
            String cmdStr=cmd[i];

            //cmd 명령어 c ,z
            if(cmdStr.length()==1){
                if(cmdStr.equals("Z")){
                    Node rev=stack.pop();
                    rev.isLive=true;

                    if(rev.next==null){
                        rev.pre.next=rev;
                    }
                    else if(rev.pre==null){
                        rev.next.pre=rev;
                    }
                    else {
                        rev.pre.next=rev;
                        rev.next.pre=rev;
                    }

                }
                else if(cmdStr.equals("C")){
                    stack.add(cur);
                    cur.isLive=false;

                    Node down=cur.next;
                    Node up=cur.pre;
                    if(up!=null)
                        up.next=down;
                    if(down!=null){
                        down.pre=up;
                        cur=down;
                    }else{
                        cur=up;
                    }
                }
            }
            // ux , dx
            else{
                //방향
                String dir=cmdStr.split(" ")[0];
                //길이
                int len=Integer.parseInt(cmdStr.split(" ")[1]);

                if(dir.equals("U")){
                    for(int j=0; j<len;j++){
                        cur=cur.pre;
                    }
                }
                else if(dir.equals("D")){
                    for(int j=0; j<len;j++){
                        cur=cur.next;
                    }
                }

            }
        }

        StringBuilder str=new StringBuilder();
        for(Node node : nodeArr){
            if(node!=null){
                if(node.isLive)
                    str.append("O");
                else
                    str.append("X");
            }
        }
        return str.toString();

    }
    public static void main (String args[]) {
        int n=8;
        int k=2;
        String []cmd={"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        표편집innerClass.solution(n,k,cmd);
    }
}
