package br.com.nex2you.api;

public class HelloWorld {

    public String sayHello(String name) {

        System.out.println("sayHello called with name : " + name);
        return "Hello " + name;
    }

}
