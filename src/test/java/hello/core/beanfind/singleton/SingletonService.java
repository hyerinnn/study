package hello.core.beanfind.singleton;

public class SingletonService {


    // 메모리에 올라가는 static으로 선언!!!
    private static final SingletonService instance = new SingletonService();


    // public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance(){
        return instance;
    }

    // 생성자를 private로 선언해서 외부에서 new 키워드를 사용한 객체생성을 못하게 막는다. (중요!!!!!!)
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
