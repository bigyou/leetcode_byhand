package in.kaixin.leetcode_byhand;

public class StaticAccess {

    public static void main(String[] args) {
        ((Acce) null).output();
    }
}

class Acce {
    public static void output() {
        System.out.println("Run success");
    }
}