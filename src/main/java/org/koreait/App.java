package org.koreait;

import org.koreait.motivation.controller.MotivationController;
import org.koreait.motivation.entity.Motivation;
import org.koreait.system.controller.SystemController;

import java.util.ArrayList;
import java.util.List;

public class App {

    public App() {
    }

    public void run() {
        System.out.println("== motivation 실행 ==");
        List<Motivation> motivations = new ArrayList<>();
        MotivationController motivationController = new MotivationController();
        SystemController systemController = new SystemController();

        while (true) {
            System.out.println("명령어) ");
            String cmd = Container.getScanner().nextLine().trim();

            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } else if (cmd.equals("")) {
                System.out.println("명령어를 입력해");
                continue;
            }


            if (cmd.equals("add")) {
                motivationController.add();
            } else if (cmd.equals("list")) {
                motivationController.list();

            } else if (cmd.startsWith("delete?id=")) {
                int idnums = Integer.parseInt(cmd.replaceAll("[^1-9]", ""));
                if (cmd.length() < idnums) {
                    System.out.println("없는 id번호입니다.");
                } else {
                    motivationController.remove(idnums);
                }
            } else if (cmd.equals("수정")) {
                motivationController.update();
            }
        }
    }
}

