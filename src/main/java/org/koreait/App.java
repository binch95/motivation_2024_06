package org.koreait;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== motivation 실행 ==");
        int motivationcount = 1;
        List<Motivation> motivations = new ArrayList<>();
        while (true) {
            System.out.println("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("== motivation 종료 ==");
                break;
            } else if (cmd.equals("")) {
                System.out.println("명령어를 입력해");
                continue;
            }


            if (cmd.equals("add")) {
                System.out.print("body : ");
                String body = sc.nextLine();
                System.out.print("source : ");
                String source = sc.nextLine();
                System.out.printf("%d번 이 등록 되었습니다", motivationcount);

                Motivation motivation = new Motivation(motivationcount, body, source);
                motivations.add(motivation);
                motivationcount++;

            } else if (cmd.equals("list")) {
                if (motivations.size() == 0) {
                    System.out.println("motivation에 정보가 없습니다.");
                    continue;
                }
                System.out.println("== motivation list ==");
                System.out.println("id  //   motivation  //  source");
                int listcount = motivations.size()-1;
                while (listcount >= 0) {
                    System.out.printf(" %s  //      %s    //     %s\n", motivations.get(listcount).id, motivations.get(listcount).body, motivations.get(listcount).source);
                    listcount -= 1;
                }

            }
        }
    }
}

class Motivation{
    int id;
    String body;
    String source;
    public Motivation(int id,String body,String source){
     this.id = id;
     this.body = body;
     this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Motivation{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

}