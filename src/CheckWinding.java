/**
 * @Author wyc1856
 * @Date 2018/9/3 16:14
 * @Description 判断两个字符串是否互为回环变位
 **/

public class CheckWinding {
    public static void main(String[] args) {
        String str1 = "31794";
        String str2 = "79431";
        String result = checkWinding(str1,str2) ? "" : "不";
        System.out.println(str1 + "和" + str2 + result + "互为回环变位");
    }

    private static boolean checkWinding(String str1, String str2){
        return str1.length() > 0 && str2.length() > 0 && (str2 + str2).contains(str1);
    }
}
