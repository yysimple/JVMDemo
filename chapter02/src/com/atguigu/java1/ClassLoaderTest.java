package com.atguigu.java1;

/**
 * @author shkstart
 * @create 2020 上午 9:22
 */
public class ClassLoaderTest {
    public static void main(String[] args) {

        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(systemClassLoader);

        //获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        //sun.misc.Launcher$ExtClassLoader@1540e19d
        System.out.println(extClassLoader);

        //获取其上层：获取不到引导类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        //null
        System.out.println(bootstrapClassLoader);

        //对于用户自定义类来说：默认使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader);

        //String类使用引导类加载器进行加载的。---> Java的核心类库都是使用引导类加载器进行加载的。
        ClassLoader classLoader1 = String.class.getClassLoader();
        //null
        System.out.println(classLoader1);


    }
}
