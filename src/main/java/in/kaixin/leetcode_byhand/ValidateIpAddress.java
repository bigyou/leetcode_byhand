package in.kaixin.leetcode_byhand;

public class ValidateIpAddress {
    public static String validIPAddress(String queryIP) {
        String[] ipv4 = queryIP.split("\\.");
        String status = "Neither";
        if (ipv4.length == 4) {
            if (queryIP.endsWith(".") || queryIP.startsWith(".")) {
                return "Neither";
            }
            status = "IPv4";
            for (int i = 0; i < 4; i++) {
                if (ipv4[i].length() == 0) {
                    return "Neither";
                }
                if (ipv4[i].length() > 1 && ipv4[i].startsWith("0")) {
                    return "Neither";
                }
                try {
                    int v = Integer.parseInt(ipv4[i]);
                    if (v < 0 || v > 255) {
                        status = "Neither";
                        break;
                    }
                } catch (Exception e) {
                    status = "Neither";
                    break;
                }

            }

        } else {
            String[] ipv6 = queryIP.split("\\:");
            if (ipv6.length == 8) {
                if (queryIP.endsWith(":") || queryIP.startsWith(":")) {
                    return "Neither";
                }
                status = "IPv6";
                for (int i = 0; i < 8; i++) {
                    String str = ipv6[i];
                    if (str == null || str.equals("") || str.length() > 4) {
                        status = "Neither";
                        break;
                    }

//                    if (str.length() > 1 && (str.equals("00")||str.equals("000")||str.equals("0000"))) {
//                        return "Neither";
//                    }
                    str = str.toLowerCase();
                    for (int j = 0; j < str.length(); j++) {
                        char c = str.charAt(j);
                        if (('0' <= c && c <= '9') || (c >= 'a' && c <= 'f')) {

                        } else {
                            status = "Neither";
                            break;
                        }
                    }
                }
            }
        }
        return status;

    }

    public static void main(String... args) {
//        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
//        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(validIPAddress("2001:db8:85a3:0::8a2E:0370:7334"));
    }
}
