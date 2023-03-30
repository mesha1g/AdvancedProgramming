package JavaOrgExample.Three.Demo;


import JavaOrgExample.Two.Collection.Person;

/**
 * Ovo je interfejs....
 *
 * Šta je funkcionalni interfejs ?
 * <p>
 *     POTREBAN i DOVOLJAN uslov da bi neki interfejs bio funkcionalan je da
 *     ima JEDNU I SAMO JEDNU apstraktnu funkciju/metodu.
 * </p>
 *
 */
public interface PersonTester {
    boolean test(Person person);
}
