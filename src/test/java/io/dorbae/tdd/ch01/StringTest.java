package io.dorbae.tdd.ch01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 *****************************************************************
 *
 * StringTest
 *
 * @description StringTest
 *
 *
 *****************************************************************
 *
 * @version 1.0.0    2021/01/04 21:37     dorbae	최초 생성
 * @since 2021/01/04 21:37
 * @author dorbae(dorbae.io @ gmail.com)
 *
 */
public class StringTest {

    @Test
    void substring() {
        String str = "abcde";
        assertEquals("cd", str.substring(2, 4));
    }

}
