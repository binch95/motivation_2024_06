package org.koreait.motivation.controller;

import org.koreait.Container;
import org.koreait.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MotivationController {
    Scanner sc;
    ArrayList<Motivation> motivations = new ArrayList<>();


    public MotivationController() {
    }

    public void add() {
        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();
        System.out.printf("%d번 이 등록 되었습니다\n", motivations.size()+1);

        Motivation motivation = new Motivation(motivations.size()+1, body, source);
        motivations.add(motivation);
    }

    public void list() {
        if (motivations.size() == 0) {
            System.out.println("등록된 motivation 없음.");
            return;
        }
        System.out.println("== motivation list ==");
        System.out.println("등록된 motivation 갯수 : " + motivations.size());
        System.out.println("id  //   source  //  body");

        for(int i = motivations.size() - 1; i >= 0; i--) {
            String five = motivations.get(i).source.length() > 5 ? "..." : "";
            System.out.printf(" %s  //    %.5s%s    //     %s\n", motivations.get(i).id, motivations.get(i).source,five, motivations.get(i).body);
        }
    }

    public void remove(int a) {
        for (int i=0; i<motivations.size(); i++) {
            if (motivations.get(i).id == a) {
                System.out.printf("%d번 motivation이 삭제되었습니다.\n",motivations.get(i).id);
                motivations.remove(i);
                break;
            }
        }

    }

    public void update() {
        System.out.print("수정하실 ID : ");
        int setid = Integer.parseInt(Container.getScanner().nextLine());
        System.out.print("수정하실 source : ");
        String setsource = Container.getScanner().nextLine();
        System.out.print("수정하실 body : ");
        String setbody = Container.getScanner().nextLine();
        for (int i=0; i<motivations.size(); i++) {
            if (motivations.get(i).id == setid) {
                System.out.printf("%d번 motivation이 수정되었습니다.\n",motivations.get(i).id);
                motivations.set(i, new Motivation(setid, setsource, setbody));
                break;
            }
        }
    }
}
