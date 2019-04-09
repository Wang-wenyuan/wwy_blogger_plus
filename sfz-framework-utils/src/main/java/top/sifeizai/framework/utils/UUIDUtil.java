package top.sifeizai.framework.utils;

import java.util.UUID;

/**
 * Created by wwy on 2019-04-09 15:02
 * 32位uuid
 */
public class UUIDUtil {
    public static String getUUID(){
        String uuida = UUID.randomUUID().toString();
        String uuid = uuida.replace("-", "");
        return uuid;
    }

    public static void main(String[] args) {
        String uuid = getUUID();
        System.out.println(uuid+":"+uuid.length());
    }
}
