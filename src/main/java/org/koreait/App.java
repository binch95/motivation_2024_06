package org.koreait;

import org.koreait.motivation.controller.MotivationController;
import org.koreait.motivation.entity.Motivation;
import org.koreait.system.controller.SystemController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    byte system_status = 1;

    public App() {
    }

    public void run() {
        System.out.println("== motivation 실행 ==");
        List<Motivation> motivations = new ArrayList<>();
        MotivationController motivationController = new MotivationController();
        SystemController systemController = new SystemController();

        while (system_status == 1) {
            System.out.print("명령어) ");
            String cmd = Container.getScanner().nextLine().trim();
            if (cmd.equals("")) {System.out.println("명령어를 입력해");}

            Rq rq = new Rq(cmd);

            switch (rq.getActionmethod()) {
                case "exit":
                    System.out.println("== motivation 종료 ==");
                    system_status = 0;
                    break;
                case "add":
                    motivationController.add();
                    break;
                case "list":
                    motivationController.list();
                    break;
                case "delete":
                    motivationController.remove(rq);
                    break;
                case "edit":
                    motivationController.update(rq);
                    break;
                default:
                    System.out.println("사용할 수 없는 명령어 입니다.");
                    break;

            }
        }
    }
}

