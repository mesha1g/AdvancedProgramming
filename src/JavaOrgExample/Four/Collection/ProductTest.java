package JavaOrgExample.Four.Collection;



import JavaOrgExample.Four.Collection.Product.Product;
import JavaOrgExample.Four.Collection.Product.ProductDao;

import java.math.BigDecimal;
import java.util.List;

/**
 * <li>1. IZVOR STREAMA</li>
 * <li>2. MEĐUOPERACIJE </li>
 * <li>3. TERMINIRAJUĆA</li>
 */
public class ProductTest {
    public static void main(String[] args) {
        // broj1.compareTo(broj2)
        // ->   moguci rezultati ->        -1  0  1
        // 1 -> kada je broj1 veći od broj2
        // 0 -> kada su broj1 i broj2 jednaki
        //-1 -> kada je broj1 manji od broj2
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getAll();
//        products.stream()
//                .filter(product -> product.getQuantityInStock()>20)
//                .filter(product -> {
//                    System.out.println("TES TEST");
//                    return product.getUnitPrice().compareTo(BigDecimal.valueOf(3))>0;
//                })
//                ;
//                .forEach(product -> System.out.println(product));
        for(Product product: products){
            if(product.getQuantityInStock()>20){
                if(product.getUnitPrice().compareTo(BigDecimal.valueOf(3))>0){
                    System.out.println("TES TEST");
                    System.out.println(product);
                }
            }
        }
    }
}
