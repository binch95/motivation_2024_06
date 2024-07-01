package org.koreait;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private Map<String, String> params;
    private String actionmethod;


    public Rq(String cmd) {

        String[] bits = cmd.split("\\?", 2);
        actionmethod = bits[0];
        params = new HashMap<>();
        if (bits.length == 1) {return;}
        String[] paramsbits;
        try {
            paramsbits = bits[1].split("&");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("명령어 잘못입력");
            return;
        }
        for (String paramStr : paramsbits) {
            String[] bits2 = paramStr.split("=", 2);
            String key = bits2[0];
            String value = bits2[1];
            params.put(key, value);
        }
    }
    public String getParams(String paramName) {
        return params.get(paramName);
    }

    public String getActionmethod() {
        return actionmethod;
    }
}
