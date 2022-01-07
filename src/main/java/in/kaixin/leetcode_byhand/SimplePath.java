package in.kaixin.leetcode_byhand;

import java.util.LinkedList;
import java.util.List;

public class SimplePath {
    //    https://leetcode-cn.com/problems/simplify-path/

    public String simplifyPath(String path) {
        String[] split = path.split("/");
        if (path == null || path == "" || path == "/") {
            return "/";
        }
        List<String> onePathList = new LinkedList<>();
//        onePathList.add("/");
        for (int i = 0; i < split.length; i++) {
            String onePath = split[i];
            if ("".equals(onePath) || ".".equals(onePath)) {
                continue;
            }
            if ("..".equals(onePath)) {
                if (onePathList.size() > 0) {
                    onePathList.remove(onePathList.size() - 1);
                }
                continue;
            }
            onePathList.add("/" + onePath);
        }
        if (onePathList.size() == 0) {
            return "/";
        }
        StringBuffer sb = new StringBuffer();
        onePathList.forEach(i -> sb.append(i));
        return sb.toString();

    }

    public static void main(String... args) {
        SimplePath simplePath = new SimplePath();
        System.out.println(simplePath.simplifyPath("/../"));
        System.out.println(simplePath.simplifyPath("/home//foo/"));
        System.out.println(simplePath.simplifyPath("/home/"));
        System.out.println(simplePath.simplifyPath("/a/./b/../../c/"));
    }
}
