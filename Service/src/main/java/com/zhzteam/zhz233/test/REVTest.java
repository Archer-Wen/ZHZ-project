package com.zhzteam.zhz233.test;

import com.zhzteam.zhz233.common.utils.REVUtils;
import org.junit.Test;

public class REVTest {
    @Test
    public void TestisLogonInfo(){
        String str="15123328416_+";
        System.err.println(REVUtils.isLogonInfo(str));
    }
}
