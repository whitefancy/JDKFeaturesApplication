package JavaBasics;

public class StuffDestuff {
    public void test(){
        java8();
    }
    private void java5(){
// java 1.5 之后出现加入自动拆装箱功能
        boolean a = false;
        Boolean b = a;
//    int 类型 不在-128 到127 之间 自动装箱后不相等
//    这是因为区间内的被放在chche数组中缓存起来，其他的系统会新建Integer实例
//        缓存可以提高性能
        Integer c1= 3;
        Integer c2 = 3;
        System.out.println(c1==c2);
        Integer c3= 128;
        Integer c4 = 128;
        System.out.println(c3==c4);
    }
    private void java7(){
//        java7为Character增加了一些工具方法
        Character a = 'A';
        int k = a.charValue();// (int)'a'
        System.out.println(k);
        String k1 = a.toString();
        a = 'a';
        k = a.charValue();
        int k2 = a.compareTo('A');// ‘a’-'A'
        System.out.println(k+" "+k1+" "+k2);
    }
    private void java8(){
        // java8 增强 支持无符号数计算

        // Integer Long转换成无符号数的字符串，正数相等，负数则为很大的值
        // 334 334 334 334
        // -334 4294966962
        //-334 18446744073709551282
        Long l = new Long(-334);
        Integer i = -334;
        String s = Integer.toUnsignedString(i);
        System.out.println(s);
        s=Long.toUnsignedString(l);
        System.out.println(s);
// Long 有与 Integer 相同的方法 整数与无符号数有相同的方法
        String s1 = "12345";
        Integer u = Integer.parseUnsignedInt(s1); //只能对正数做转换
        System.out.println(u);
        u = Integer.parseUnsignedInt("1110101",2);// 按照 r进制转换成无符号数 117
        System.out.println(u);
        u = Integer.parseUnsignedInt("ADFES",36);// 按照 r进制转换成无符号数 17422660
        System.out.println(u);

        // 无符号数 比较大小 取商 取余
        Long  b = new Long(23244);
        Long a = new Long(284033);
        // compare
        int c = Long.compareUnsigned(a,b);
        System.out.println(c);
        long c1 = Long.divideUnsigned(a,b);//取商
        System.out.println(c1);
        c1 = Long.remainderUnsigned(a,b);//取余
        System.out.println(c1);

        // 将Byte Short 转换成无符号数
        Byte by = new Byte("127");// byte 只能是 -128 到127之间的数字的字符串形式 ，不能是字母
        System.out.println(by);
        Short sh = 23;//-32768  32767 之间的数字
        Byte.toUnsignedLong(by);
        Short.toUnsignedInt(sh);
    }
}
