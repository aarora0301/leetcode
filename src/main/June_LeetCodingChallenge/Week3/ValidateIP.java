package main.June_LeetCodingChallenge.Week3;

/****
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 *
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each
 * ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 *
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 *
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The
 * groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid
 * one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the
 * address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros
 * and using upper cases).
 *
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive
 * colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 *
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address
 * 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 *
 *
 *
 * Example 1:
 *
 * Input: IP = "172.16.254.1"
 * Output: "IPv4"
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * Example 2:
 *
 * Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * Output: "IPv6"
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * Example 3:
 *
 * Input: IP = "256.256.256.256"
 * Output: "Neither"
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 *
 *
 * Constraints:
 *
 * IP consists only of English letters, digits and the characters "." and ":".
 */
public class ValidateIP {

    private String validateIPv4(String IP) {
        String[] nums = IP.split("\\.", -1);
        for (String num : nums) {

            // Validate integer in range (0, 255):
            // 1. length of chunk is between 1 and 3
            if (num.length() == 0 || num.length() > 3) {
                return "Neither";
            }
            // 2. no extra leading zeros
            if (num.charAt(0) == '0' && num.length() != 1) {
                return "Neither";
            }
            // 3. only digits are allowed
            for (char ch : num.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return "Neither";
                }
            }
            // 4. less than 255
            if (Integer.parseInt(num) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    private String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String num : nums) {
            // Validate hexadecimal in range (0, 2**16):
            // 1. at least one and not more than 4 hexdigits in one chunk
            if (num.length() == 0 || num.length() > 4) {
                return "Neither";
            }
            // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (char ch : num.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

    public String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        } else return "Neither";
    }

    public static void main(String[] args) {
        ValidateIP test= new ValidateIP();
        System.out.println(test.validIPAddress("172.16.254.1"));
    }
}
