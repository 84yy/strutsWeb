package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.ProductDao;
import entity.Product;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ProductAction extends ActionSupport {
    private ProductDao productDao=new ProductDao();
    private Product product;

    public String show(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        Integer id=Integer.parseInt(request.getParameter("id"));
        this.product=productDao.get(id);
        return SUCCESS;
    }

    public Product getProduct(){
        return product;
    }

    public void setProduct(Product p){
        this.product=p;
    }

    public String add(){
        Map m=ActionContext.getContext().getSession();
        m.put("name",this.product.getName());
        System.out.println("product.name"+this.product.getName());
        productDao.add(product);
        return SUCCESS;
    }
}
