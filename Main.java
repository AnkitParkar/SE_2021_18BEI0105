package HitWicketChess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Object[][] fin=new Object[5][5];
    static List<String> firstName=new ArrayList<>();
    static List<String> secondName=new ArrayList<>();


    public static void main(String[] args) {
        for(int i=0;i<fin.length;i++){
            for(int j=0;j<fin.length;j++)
                fin[i][j]='-';
        }

        disp();
        getNames();
        System.out.println("Finished getting names");
        names();
        firstInsert();
        disp();
    }

    private static boolean getNames(){
        Scanner sc=new Scanner(System.in);
        System.out.println("For player one, enter names seperated by space:");
        StringBuffer inp=new StringBuffer(sc.nextLine());
        List<String> temp=new ArrayList<>();
        //System.out.println(inp.toString());
        int j=0,i=0;
        String a="";
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
        for(i=0;i<temp.size();i++) firstName.add("A-"+temp.get(i));
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
        for(i=0;i<temp.size();i++) secondName.add("B-"+temp.get(i));
        return true;
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
