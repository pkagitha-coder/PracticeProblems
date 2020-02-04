package org.abc;

import java.net.URL;

public class TestFilePath {

    public static void main(String[] args) {
        URL resource = TestFilePath.class.getResource("/triplets_case_04.txt");
        System.out.println(resource.getPath());
    }
}
