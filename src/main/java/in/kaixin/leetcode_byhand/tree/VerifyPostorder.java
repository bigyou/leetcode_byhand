//package in.kaixin.leetcode_byhand.tree;
//
//public class VerifyPostorder {
//    public boolean verifyPostorder(int[] postorder) {
//        if (postorder == null || postorder.length <= 2) {
//            return true;
//        }
//        boolean valid = verify(postorder);
//        return valid;
//
//    }
//
//    public boolean verify(int[] postorder) {
//        int root = postorder[postorder.length - 1];
//        int next = postorder[postorder.length - 2];
//        boolean valid = true;
//        if (next > root) {
//            valid = valid & verifyright(postorder, postorder.length - 1, root, Integer.MAX_VALUE);
//            if (valid && postorder.length - 3 >= 0) {
//                if (postorder[postorder.length - 3] < root) {
//                    valid = valid & verifyleft(postorder, postorder.length - 1, Integer.MIN_VALUE, root);
//                }
//            }
//        } else {
//            verifyleft(postorder, postorder.length - 1, Integer.MIN_VALUE, root);
//        }
//        return true;
//    }
//
//    public boolean verifyright(int[] postorder, int end, int min, int max) {
//        if (postorder[end] > max || postorder[end] < min) {
//            return false;
//        }
//        int v = postorder[end - 1];
//        if (v > postorder[end]) {
//            verifyright(postorder, end - 1, postorder[end], max);
//            if (end - 2 >= 0 && postorder[end - 2] < postorder[end]) {
//                verifyleft(postorder, end - 2, min, postorder[end]);
//            }
//        } else {
//            verifyleft(postorder, end - 1, min, postorder[end]);
//        }
//    }
//
//    public boolean verifyleft(int[] postorder, int end, int min, int max) {
//        if (postorder[end] > max || postorder[end] < min) {
//            return false;
//        }
//        if (end < 1) {
//            return true;
//        }
//        int v = postorder[end - 1];
//        if (v > postorder[end]) {
//            verifyright(postorder, end - 1, postorder[end], max);
//            if (end - 2 >= 0 && postorder[end - 2] < postorder[end]) {
//                verifyleft(postorder, end - 2, min, postorder[end]);
//            }
//        } else {
//            verifyleft(postorder, end - 1, min, postorder[end]);
//        }
//        return true;
//    }
//
//}