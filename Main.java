package HitWicketChess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Object[][] fin=new Object[5][5];
    static List<String> firstName=new ArrayList<>();
    static List<String> secondName=new ArrayList<>();
    static int firstCount=5, secondCount=5;
    static Scanner sc=new Scanner(System.in);
    static List<Character> pMoves= new ArrayList<>();
    static HashMap<String, Integer> pos=new HashMap<>();


    public static void main(String[] args) {
        for(int i=0;i<fin.length;i++){ for(int j=0;j<fin.length;j++) fin[i][j]='-'; }
        disp();
        getNames();
        names();
        firstInsert();
        disp();
        for(String i:pos.keySet()){
            System.out.println("Key: "+i+" pos: "+pos.get(i));
        }
        boolean flag=true;
        while( firstCount>0 && secondCount>0){
            disp();
            move(flag);
            flag=!flag;
        }
    }

    private static void move(boolean flag){
        if (flag) {
            if (firstMove()) return;
            else firstMove();
        }
        else{
            if (secondMove()) return;
            else secondMove();
        }
    }

    private static boolean firstMove(){
        System.out.println("Player A's Move:");
        StringBuffer inp=new StringBuffer(sc.nextLine());
        String piece=(String) inp.substring(0,2);
        char move=inp.charAt(3);
        if (piece.charAt(0)=='P') {
            if (!pMoves.contains(move)){
                System.out.println("Move does not exist");
                return false;
            }
        }
        if(!pos.keySet().contains("A-"+piece)){
            System.out.println("Piece does not exist");
            return false;
        }
        int row=pos.get("A-"+piece)/10,col=pos.get("A-"+piece)%10;
        System.out.println("Current pos: "+row+":"+col);

        return true;
    }

    private static boolean secondMove(){

        return true;
    }

    private static boolean pMove(String piece,char move){
        switch (move){
            case 'F':
                
        }
    }

    private static boolean getNames(){
        System.out.println("For player one, enter names seperated by space:");
        StringBuffer inp=new StringBuffer(sc.nextLine());
        List<String> temp=new ArrayList<>();
        //System.out.println(inp.toString());
        int j=0,i=0,pTrue=0;
        String a="";
        for(i=0;i<inp.length();i=j+2){
            j=i+1;
            inner:
            for(;j<inp.length();j++)
                if (inp.charAt(j)==',') break inner;
            a=inp.substring(i,j);
            if (a.charAt(0)=='P') pTrue+=1;
            //System.out.println(a);
            if (!temp.contains(a)) temp.add(a);
            else{
                System.out.println("Two characters cannot have the same name. Please enter again");
                return false;
            }
        }
        for(i=0;i<temp.size();i++){
            firstName.add("A-"+temp.get(i));
            pos.put(firstName.get(i),0*10+i);
        }
        temp.clear();
        System.out.println("For player two, enter names seperated by space:");
        inp=new StringBuffer(sc.nextLine());
        for(i=0;i<inp.length();i=j+2){
            j=i+1;
            inner:
            for(;j<inp.length();j++)
                if (inp.charAt(j)==',') break inner;
            a=inp.substring(i,j);
            //System.out.println(a);
            if (!temp.contains(a)) temp.add(a);
            else{
                System.out.println("Two characters cannot have the same name. Please enter again");
                return false;
            }
        }
        for(i=0;i<temp.size();i++){
            secondName.add("B-"+temp.get(i));
            pos.put(secondName.get(i),4*10+i);
        }
        if (pTrue>0) initP();
        return true;
    }

    private static void initP(){
        pMoves.add('F');
        pMoves.add('L');
        pMoves.add('B');
        pMoves.add('R');
    }

    private static void names(){
        for(String i:firstName)
            System.out.print(i+", ");
        System.out.println();
        for(String i:secondName)
            System.out.print(i+", ");
    }

    private static void firstInsert(){
        for(int i=0;i<fin.length;i++){
            fin[0][i]=firstName.get(i);
            fin[fin.length-1][i]=secondName.get(i);
        }
    }
    private static void disp(){
        System.out.println();
        for (Object[] objects : fin) {
            for (int j = 0; j < fin.length; j++) {
                if (objects[j] == (Object) '-') {
                    System.out.print("   -  ");
                } else System.out.print(" "+objects[j]+" ");
            }
            System.out.println();
        }
    }
}
