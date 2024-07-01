package org.koreait.motivation.controller;

import org.koreait.Container;
import org.koreait.Rq;
import org.koreait.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MotivationController {
    int editId;
    Scanner sc;
    ArrayList<Motivation> motivations = new ArrayList<>();


    public MotivationController() {
    }

    public void add() {
        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();
        System.out.printf("%d번 이 등록 되었습니다\n", motivations.size() + 1);

        Motivation motivation = new Motivation(motivations.size() + 1, body, source);
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

        for (int i = motivations.size() - 1; i >= 0; i--) {
            String five = motivations.get(i).getSource().length() > 5 ? "..." : "";
            System.out.printf(" %s  //    %.5s%s    //     %s\n", motivations.get(i).getId(), motivations.get(i).getSource(), five, motivations.get(i).getBody());
        }
    }

    public void remove(Rq rq) {
        int id;
        try{
            id = Integer.parseInt(rq.getParams("id"));
        }catch (NumberFormatException e) {
            System.out.println("잘못 입력했어");
            return;
        }
        Motivation motivation = findBy(id);
        if (motivation == null) {
            System.out.printf("%d번 motivation은 없어\n");
            return;
        }
        motivations.remove(motivation);
        System.out.printf("%d번 motivation을 삭제했습니다.\n",id);

    }


    public void update(Rq rq) {
        int id;
        try{
            id = Integer.parseInt(rq.getParams("id"));
        }catch (NumberFormatException e) {
            System.out.println("잘못 입력했어");
            return;
        }
        Motivation motivation = findBy(id);
        if (motivation == null) {
            System.out.printf("%d번 motivation은 없어\n", id);
            return;
        }
        System.out.print("body : ");
        String body = Container.getScanner().nextLine();
        System.out.print("source : ");
        String source = Container.getScanner().nextLine();
        motivation.setBody(body);
        motivation.setSource(source);
        System.out.printf("%d번 motivation이 수정 되었습니다.\n",id);
    }

    private Motivation findBy(int id) {
        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                return motivation;
            }
        }
        return null;
    }

}