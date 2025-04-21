package net.rahli.pres;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.rahli.metier.IMetier;

public class PresSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("net.rahli");
        IMetier metier = applicationContext.<IMetier>getBean(IMetier.class);
        System.out.println("RES=" + metier.calcul());
    }
}
