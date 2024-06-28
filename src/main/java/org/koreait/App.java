package org.koreait;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private Scanner sc ;
    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== motivation 실행 ==");
        int motivationcount = 1;
        ArrayList<String> motlist = new ArrayList();
        while(true) {
            System.out.println("명령어) ");
            String cmd = sc.nextLine().trim();

            if(cmd.equals("exit")) {
                System.out.println("== motivation 종료 ==");
                break;
            } else if(cmd.equals("")) {
                System.out.println("명령어를 입력해");
                continue;
            }


            if(cmd.equals("add")) {
                System.out.print("motivation : ");
                String motivation = sc.nextLine();
                System.out.print("source : ");
                String source = sc.nextLine();
                System.out.printf("%d번 이 등록 되었습니다",motivationcount);
                motlist.add(String.valueOf(motivationcount));
                motlist.add(motivation);
                motlist.add(source);
                motivationcount += 1;
            }else if(cmd.equals("list")) {
                if(motlist.size() == 0) {
                    System.out.println("motivation에 정보가 없습니다.");
                    continue;
                }
                System.out.println("== motivation list ==");
                System.out.println("id  //   motivation  //  source");
                int listcount = motlist.size()-1;
                while(listcount > 0) {
                System.out.printf(" %s  //      %s    //     %s\n",motlist.get(listcount-2), motlist.get(listcount-1) ,motlist.get(listcount) );
                listcount -= 3;
                }
            }



        }
    }
}
