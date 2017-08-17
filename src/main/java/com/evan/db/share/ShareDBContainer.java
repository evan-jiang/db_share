package com.evan.db.share;

import java.util.HashMap;
import java.util.Map;

public class ShareDBContainer {

    private static final Map<String, String> ALL_PRODUCT_CODE = new HashMap<String, String>();
    
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<String>();
    
    static{
        ALL_PRODUCT_CODE.put("A", "db_001");
        ALL_PRODUCT_CODE.put("B", "db_002");
        ALL_PRODUCT_CODE.put("C", "db_003");
        ALL_PRODUCT_CODE.put("D", "db_001");
        ALL_PRODUCT_CODE.put("E", "db_002");
        ALL_PRODUCT_CODE.put("F", "db_003");
        ALL_PRODUCT_CODE.put("G", "db_001");
        ALL_PRODUCT_CODE.put("H", "db_002");
        ALL_PRODUCT_CODE.put("I", "db_003");
        ALL_PRODUCT_CODE.put("J", "db_001");
        ALL_PRODUCT_CODE.put("K", "db_002");
        ALL_PRODUCT_CODE.put("L", "db_003");
        ALL_PRODUCT_CODE.put("M", "db_001");
        ALL_PRODUCT_CODE.put("N", "db_002");
        ALL_PRODUCT_CODE.put("O", "db_003");
        ALL_PRODUCT_CODE.put("P", "db_001");
        ALL_PRODUCT_CODE.put("Q", "db_002");
        ALL_PRODUCT_CODE.put("R", "db_003");
        ALL_PRODUCT_CODE.put("S", "db_001");
        ALL_PRODUCT_CODE.put("T", "db_002");
        ALL_PRODUCT_CODE.put("U", "db_003");
        ALL_PRODUCT_CODE.put("V", "db_001");
        ALL_PRODUCT_CODE.put("W", "db_002");
        ALL_PRODUCT_CODE.put("X", "db_003");
        ALL_PRODUCT_CODE.put("Y", "db_001");
        ALL_PRODUCT_CODE.put("Z", "db_002");
    }
    public static boolean rightfulProductCode(String productCode){
        return ALL_PRODUCT_CODE.containsKey(productCode);
    }
    public static void setDataSource(String productCode){
        THREAD_LOCAL.set(ALL_PRODUCT_CODE.get(productCode));
    }
    public static String getDataSource(){
        return THREAD_LOCAL.get();
    }
}
