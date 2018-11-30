package other;

/**
 * @Author wyc1856
 *
 * 翻转字符串算法实现
 * 如：请把“I am a student.”，翻转成“I ma a .tneduts”.
 */
public class OverturnString {

    public static void main(String[] args) {
        System.out.println(doThis("i am a student."));
    }

    /**
     *翻转字符串操作
     *
     * @param str 待翻转字符串
     * @return 翻转后的字符串
     */
    private static String doThis(String str){
        char[] chars = str.toCharArray();
        int start = 0;
        int end = 0;
        while (end <= str.length() - 1){
            //遇到空格，翻转单词
            if (chars[end] == ' '){
                reverseCharArray(chars, start, end - 1);
                start = end + 1;
            }
            //翻转最后一个单词，因为最后一个单词没有空格
            if (end == str.length() - 1){
                reverseCharArray(chars,start,end);
            }
            end ++;
        }
        return new String(chars);
    }

    private static void reverseCharArray(char[] chars, int start, int end){
        //首尾交换
       while (start < end){
           char t = chars[start];
           chars[start] = chars[end];
           chars[end] = t;
           start ++;
           end --;
       }
    }
}
