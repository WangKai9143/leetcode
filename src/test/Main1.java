package test;

public class Main1 {

    static Main1 main1 = new Main1();

    Main1 getMain1() {
        return main1;
    }

    public <T> T getBean(Class<T> clazz) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        T bean = (T) Class.forName("test.Father").newInstance();
        return bean;
    }

    static class Father {
        public static void test1() {
            System.out.println("father");
        }

        public void test2() {
            System.out.println("father");
        }
    }

    static class Child extends Father {
        public static void test1() {
            System.out.println("child");
        }

        public void test2() {
            System.out.println("child");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {
//        Father father = new Child();
////        father.test1();
//
//        father.test2();
//
//        int[] aaa = {1, 2, 3};
//        Set set = new HashSet();
//        set.add(Arrays.asList(aaa));
//        System.out.println(aaa);
//
//        List list = new ArrayList();
//
//        Arrays.stream(aaa);
////        char a = '\n';
////
////
////        List<String>  aaa = new ArrayList<>();
////        aaa.add("1111");
////        aaa.add(2,"2222");
////        System.out.println("aaa.get(1)"+aaa.get(1));
//
//        main1.getMain1();
//        main1.getBean(Father.class);
//
//        Thread thread = new Thread(() ->{
//
//        });

        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(2000);
        myThread.interrupt();
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            while (true) {
                if (Thread.interrupted()) {
                    System.out.println("thread is interrupted");
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("sleep is interrupted");
                }
            }
        }
    }
}