package JavaOrgExample.Five;


import JavaOrgExample.Four.Collection.Product.Product;
import JavaOrgExample.Four.Collection.Product.ProductDao;

public class DemoTest {
    public static void main(String[] args) {

        /**
         * Da bi pozvali funkciju getInstance() mora li postojati objekat kreiran po šablonu klase
         * ConnectionPool ???
         * <li> getInstance() --> STATIC </li>
         */
        ProductDao productDao = new ProductDao();
        for (int i = 1; i <= 12; i++) {
            Product product = productDao.get(i);
            System.out.println(product);
        }
    }
}
